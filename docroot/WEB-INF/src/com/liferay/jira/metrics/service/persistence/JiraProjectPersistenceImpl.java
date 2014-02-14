/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jira.metrics.service.persistence;

import com.liferay.jira.metrics.NoSuchJiraProjectException;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.impl.JiraProjectImpl;
import com.liferay.jira.metrics.model.impl.JiraProjectModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the jira project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraProjectPersistence
 * @see JiraProjectUtil
 * @generated
 */
public class JiraProjectPersistenceImpl extends BasePersistenceImpl<JiraProject>
	implements JiraProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JiraProjectUtil} to access the jira project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JiraProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, JiraProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, JiraProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LABEL = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, JiraProjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLabel",
			new String[] { String.class.getName() },
			JiraProjectModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABEL = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLabel",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira project where key = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	 *
	 * @param key the key
	 * @return the matching jira project
	 * @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject findByLabel(String key)
		throws NoSuchJiraProjectException, SystemException {
		JiraProject jiraProject = fetchByLabel(key);

		if (jiraProject == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraProjectException(msg.toString());
		}

		return jiraProject;
	}

	/**
	 * Returns the jira project where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject fetchByLabel(String key) throws SystemException {
		return fetchByLabel(key, true);
	}

	/**
	 * Returns the jira project where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject fetchByLabel(String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LABEL,
					finderArgs, this);
		}

		if (result instanceof JiraProject) {
			JiraProject jiraProject = (JiraProject)result;

			if (!Validator.equals(key, jiraProject.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRAPROJECT_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_LABEL_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LABEL_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_LABEL_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<JiraProject> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL,
						finderArgs, list);
				}
				else {
					JiraProject jiraProject = list.get(0);

					result = jiraProject;

					cacheResult(jiraProject);

					if ((jiraProject.getKey() == null) ||
							!jiraProject.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL,
							finderArgs, jiraProject);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LABEL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (JiraProject)result;
		}
	}

	/**
	 * Removes the jira project where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the jira project that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject removeByLabel(String key)
		throws NoSuchJiraProjectException, SystemException {
		JiraProject jiraProject = findByLabel(key);

		return remove(jiraProject);
	}

	/**
	 * Returns the number of jira projects where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching jira projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLabel(String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABEL;

		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JIRAPROJECT_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_LABEL_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LABEL_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_LABEL_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LABEL_KEY_1 = "jiraProject.key IS NULL";
	private static final String _FINDER_COLUMN_LABEL_KEY_2 = "jiraProject.key = ?";
	private static final String _FINDER_COLUMN_LABEL_KEY_3 = "(jiraProject.key IS NULL OR jiraProject.key = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, JiraProjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			JiraProjectModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira project where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching jira project
	 * @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject findByName(String name)
		throws NoSuchJiraProjectException, SystemException {
		JiraProject jiraProject = fetchByName(name);

		if (jiraProject == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraProjectException(msg.toString());
		}

		return jiraProject;
	}

	/**
	 * Returns the jira project where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the jira project where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof JiraProject) {
			JiraProject jiraProject = (JiraProject)result;

			if (!Validator.equals(name, jiraProject.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRAPROJECT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<JiraProject> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					JiraProject jiraProject = list.get(0);

					result = jiraProject;

					cacheResult(jiraProject);

					if ((jiraProject.getName() == null) ||
							!jiraProject.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, jiraProject);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (JiraProject)result;
		}
	}

	/**
	 * Removes the jira project where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the jira project that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject removeByName(String name)
		throws NoSuchJiraProjectException, SystemException {
		JiraProject jiraProject = findByName(name);

		return remove(jiraProject);
	}

	/**
	 * Returns the number of jira projects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching jira projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JIRAPROJECT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "jiraProject.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "jiraProject.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(jiraProject.name IS NULL OR jiraProject.name = '')";

	public JiraProjectPersistenceImpl() {
		setModelClass(JiraProject.class);
	}

	/**
	 * Caches the jira project in the entity cache if it is enabled.
	 *
	 * @param jiraProject the jira project
	 */
	@Override
	public void cacheResult(JiraProject jiraProject) {
		EntityCacheUtil.putResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectImpl.class, jiraProject.getPrimaryKey(), jiraProject);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL,
			new Object[] { jiraProject.getKey() }, jiraProject);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { jiraProject.getName() }, jiraProject);

		jiraProject.resetOriginalValues();
	}

	/**
	 * Caches the jira projects in the entity cache if it is enabled.
	 *
	 * @param jiraProjects the jira projects
	 */
	@Override
	public void cacheResult(List<JiraProject> jiraProjects) {
		for (JiraProject jiraProject : jiraProjects) {
			if (EntityCacheUtil.getResult(
						JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
						JiraProjectImpl.class, jiraProject.getPrimaryKey()) == null) {
				cacheResult(jiraProject);
			}
			else {
				jiraProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jira projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JiraProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JiraProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jira project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JiraProject jiraProject) {
		EntityCacheUtil.removeResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectImpl.class, jiraProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(jiraProject);
	}

	@Override
	public void clearCache(List<JiraProject> jiraProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JiraProject jiraProject : jiraProjects) {
			EntityCacheUtil.removeResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
				JiraProjectImpl.class, jiraProject.getPrimaryKey());

			clearUniqueFindersCache(jiraProject);
		}
	}

	protected void cacheUniqueFindersCache(JiraProject jiraProject) {
		if (jiraProject.isNew()) {
			Object[] args = new Object[] { jiraProject.getKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LABEL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL, args,
				jiraProject);

			args = new Object[] { jiraProject.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				jiraProject);
		}
		else {
			JiraProjectModelImpl jiraProjectModelImpl = (JiraProjectModelImpl)jiraProject;

			if ((jiraProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LABEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraProject.getKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LABEL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL, args,
					jiraProject);
			}

			if ((jiraProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraProject.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					jiraProject);
			}
		}
	}

	protected void clearUniqueFindersCache(JiraProject jiraProject) {
		JiraProjectModelImpl jiraProjectModelImpl = (JiraProjectModelImpl)jiraProject;

		Object[] args = new Object[] { jiraProject.getKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LABEL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LABEL, args);

		if ((jiraProjectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LABEL.getColumnBitmask()) != 0) {
			args = new Object[] { jiraProjectModelImpl.getOriginalKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LABEL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LABEL, args);
		}

		args = new Object[] { jiraProject.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((jiraProjectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { jiraProjectModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new jira project with the primary key. Does not add the jira project to the database.
	 *
	 * @param jiraProjectId the primary key for the new jira project
	 * @return the new jira project
	 */
	@Override
	public JiraProject create(long jiraProjectId) {
		JiraProject jiraProject = new JiraProjectImpl();

		jiraProject.setNew(true);
		jiraProject.setPrimaryKey(jiraProjectId);

		return jiraProject;
	}

	/**
	 * Removes the jira project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraProjectId the primary key of the jira project
	 * @return the jira project that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject remove(long jiraProjectId)
		throws NoSuchJiraProjectException, SystemException {
		return remove((Serializable)jiraProjectId);
	}

	/**
	 * Removes the jira project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jira project
	 * @return the jira project that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject remove(Serializable primaryKey)
		throws NoSuchJiraProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JiraProject jiraProject = (JiraProject)session.get(JiraProjectImpl.class,
					primaryKey);

			if (jiraProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJiraProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jiraProject);
		}
		catch (NoSuchJiraProjectException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected JiraProject removeImpl(JiraProject jiraProject)
		throws SystemException {
		jiraProject = toUnwrappedModel(jiraProject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jiraProject)) {
				jiraProject = (JiraProject)session.get(JiraProjectImpl.class,
						jiraProject.getPrimaryKeyObj());
			}

			if (jiraProject != null) {
				session.delete(jiraProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jiraProject != null) {
			clearCache(jiraProject);
		}

		return jiraProject;
	}

	@Override
	public JiraProject updateImpl(
		com.liferay.jira.metrics.model.JiraProject jiraProject)
		throws SystemException {
		jiraProject = toUnwrappedModel(jiraProject);

		boolean isNew = jiraProject.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jiraProject.isNew()) {
				session.save(jiraProject);

				jiraProject.setNew(false);
			}
			else {
				session.merge(jiraProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JiraProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
			JiraProjectImpl.class, jiraProject.getPrimaryKey(), jiraProject);

		clearUniqueFindersCache(jiraProject);
		cacheUniqueFindersCache(jiraProject);

		return jiraProject;
	}

	protected JiraProject toUnwrappedModel(JiraProject jiraProject) {
		if (jiraProject instanceof JiraProjectImpl) {
			return jiraProject;
		}

		JiraProjectImpl jiraProjectImpl = new JiraProjectImpl();

		jiraProjectImpl.setNew(jiraProject.isNew());
		jiraProjectImpl.setPrimaryKey(jiraProject.getPrimaryKey());

		jiraProjectImpl.setJiraProjectId(jiraProject.getJiraProjectId());
		jiraProjectImpl.setCreateDate(jiraProject.getCreateDate());
		jiraProjectImpl.setModifiedDate(jiraProject.getModifiedDate());
		jiraProjectImpl.setKey(jiraProject.getKey());
		jiraProjectImpl.setName(jiraProject.getName());

		return jiraProjectImpl;
	}

	/**
	 * Returns the jira project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira project
	 * @return the jira project
	 * @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJiraProjectException, SystemException {
		JiraProject jiraProject = fetchByPrimaryKey(primaryKey);

		if (jiraProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJiraProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jiraProject;
	}

	/**
	 * Returns the jira project with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	 *
	 * @param jiraProjectId the primary key of the jira project
	 * @return the jira project
	 * @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject findByPrimaryKey(long jiraProjectId)
		throws NoSuchJiraProjectException, SystemException {
		return findByPrimaryKey((Serializable)jiraProjectId);
	}

	/**
	 * Returns the jira project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira project
	 * @return the jira project, or <code>null</code> if a jira project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JiraProject jiraProject = (JiraProject)EntityCacheUtil.getResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
				JiraProjectImpl.class, primaryKey);

		if (jiraProject == _nullJiraProject) {
			return null;
		}

		if (jiraProject == null) {
			Session session = null;

			try {
				session = openSession();

				jiraProject = (JiraProject)session.get(JiraProjectImpl.class,
						primaryKey);

				if (jiraProject != null) {
					cacheResult(jiraProject);
				}
				else {
					EntityCacheUtil.putResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
						JiraProjectImpl.class, primaryKey, _nullJiraProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JiraProjectModelImpl.ENTITY_CACHE_ENABLED,
					JiraProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jiraProject;
	}

	/**
	 * Returns the jira project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jiraProjectId the primary key of the jira project
	 * @return the jira project, or <code>null</code> if a jira project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraProject fetchByPrimaryKey(long jiraProjectId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jiraProjectId);
	}

	/**
	 * Returns all the jira projects.
	 *
	 * @return the jira projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira projects
	 * @param end the upper bound of the range of jira projects (not inclusive)
	 * @return the range of jira projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira projects
	 * @param end the upper bound of the range of jira projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jira projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraProject> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<JiraProject> list = (List<JiraProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JIRAPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JIRAPROJECT;

				if (pagination) {
					sql = sql.concat(JiraProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JiraProject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraProject>(list);
				}
				else {
					list = (List<JiraProject>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the jira projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JiraProject jiraProject : findAll()) {
			remove(jiraProject);
		}
	}

	/**
	 * Returns the number of jira projects.
	 *
	 * @return the number of jira projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JIRAPROJECT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the jira project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.jira.metrics.model.JiraProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JiraProject>> listenersList = new ArrayList<ModelListener<JiraProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JiraProject>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(JiraProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JIRAPROJECT = "SELECT jiraProject FROM JiraProject jiraProject";
	private static final String _SQL_SELECT_JIRAPROJECT_WHERE = "SELECT jiraProject FROM JiraProject jiraProject WHERE ";
	private static final String _SQL_COUNT_JIRAPROJECT = "SELECT COUNT(jiraProject) FROM JiraProject jiraProject";
	private static final String _SQL_COUNT_JIRAPROJECT_WHERE = "SELECT COUNT(jiraProject) FROM JiraProject jiraProject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JiraProjectPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
	private static JiraProject _nullJiraProject = new JiraProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JiraProject> toCacheModel() {
				return _nullJiraProjectCacheModel;
			}
		};

	private static CacheModel<JiraProject> _nullJiraProjectCacheModel = new CacheModel<JiraProject>() {
			@Override
			public JiraProject toEntityModel() {
				return _nullJiraProject;
			}
		};
}