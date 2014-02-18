/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.liferay.jira.metrics.NoSuchJiraStatusException;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.model.impl.JiraStatusImpl;
import com.liferay.jira.metrics.model.impl.JiraStatusModelImpl;

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

/**
 * The persistence implementation for the jira status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraStatusPersistence
 * @see JiraStatusUtil
 * @generated
 */
public class JiraStatusPersistenceImpl extends BasePersistenceImpl<JiraStatus>
	implements JiraStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JiraStatusUtil} to access the jira status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JiraStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, JiraStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, JiraStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STATUS = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, JiraStatusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStatus",
			new String[] { String.class.getName() },
			JiraStatusModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira status where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching jira status
	 * @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus findByStatus(String name)
		throws NoSuchJiraStatusException, SystemException {
		JiraStatus jiraStatus = fetchByStatus(name);

		if (jiraStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraStatusException(msg.toString());
		}

		return jiraStatus;
	}

	/**
	 * Returns the jira status where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus fetchByStatus(String name) throws SystemException {
		return fetchByStatus(name, true);
	}

	/**
	 * Returns the jira status where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus fetchByStatus(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STATUS,
					finderArgs, this);
		}

		if (result instanceof JiraStatus) {
			JiraStatus jiraStatus = (JiraStatus)result;

			if (!Validator.equals(name, jiraStatus.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRASTATUS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_STATUS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_STATUS_NAME_2);
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

				List<JiraStatus> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
						finderArgs, list);
				}
				else {
					JiraStatus jiraStatus = list.get(0);

					result = jiraStatus;

					cacheResult(jiraStatus);

					if ((jiraStatus.getName() == null) ||
							!jiraStatus.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
							finderArgs, jiraStatus);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS,
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
			return (JiraStatus)result;
		}
	}

	/**
	 * Removes the jira status where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the jira status that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus removeByStatus(String name)
		throws NoSuchJiraStatusException, SystemException {
		JiraStatus jiraStatus = findByStatus(name);

		return remove(jiraStatus);
	}

	/**
	 * Returns the number of jira statuses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching jira statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JIRASTATUS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_STATUS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_STATUS_NAME_2);
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

	private static final String _FINDER_COLUMN_STATUS_NAME_1 = "jiraStatus.name IS NULL";
	private static final String _FINDER_COLUMN_STATUS_NAME_2 = "jiraStatus.name = ?";
	private static final String _FINDER_COLUMN_STATUS_NAME_3 = "(jiraStatus.name IS NULL OR jiraStatus.name = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_URI = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, JiraStatusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUri",
			new String[] { String.class.getName() },
			JiraStatusModelImpl.URI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_URI = new FinderPath(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUri",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira status where uri = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	 *
	 * @param uri the uri
	 * @return the matching jira status
	 * @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus findByUri(String uri)
		throws NoSuchJiraStatusException, SystemException {
		JiraStatus jiraStatus = fetchByUri(uri);

		if (jiraStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uri=");
			msg.append(uri);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraStatusException(msg.toString());
		}

		return jiraStatus;
	}

	/**
	 * Returns the jira status where uri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uri the uri
	 * @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus fetchByUri(String uri) throws SystemException {
		return fetchByUri(uri, true);
	}

	/**
	 * Returns the jira status where uri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uri the uri
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus fetchByUri(String uri, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { uri };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_URI,
					finderArgs, this);
		}

		if (result instanceof JiraStatus) {
			JiraStatus jiraStatus = (JiraStatus)result;

			if (!Validator.equals(uri, jiraStatus.getUri())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRASTATUS_WHERE);

			boolean bindUri = false;

			if (uri == null) {
				query.append(_FINDER_COLUMN_URI_URI_1);
			}
			else if (uri.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URI_URI_3);
			}
			else {
				bindUri = true;

				query.append(_FINDER_COLUMN_URI_URI_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUri) {
					qPos.add(uri);
				}

				List<JiraStatus> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
						finderArgs, list);
				}
				else {
					JiraStatus jiraStatus = list.get(0);

					result = jiraStatus;

					cacheResult(jiraStatus);

					if ((jiraStatus.getUri() == null) ||
							!jiraStatus.getUri().equals(uri)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
							finderArgs, jiraStatus);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI,
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
			return (JiraStatus)result;
		}
	}

	/**
	 * Removes the jira status where uri = &#63; from the database.
	 *
	 * @param uri the uri
	 * @return the jira status that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus removeByUri(String uri)
		throws NoSuchJiraStatusException, SystemException {
		JiraStatus jiraStatus = findByUri(uri);

		return remove(jiraStatus);
	}

	/**
	 * Returns the number of jira statuses where uri = &#63;.
	 *
	 * @param uri the uri
	 * @return the number of matching jira statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUri(String uri) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_URI;

		Object[] finderArgs = new Object[] { uri };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JIRASTATUS_WHERE);

			boolean bindUri = false;

			if (uri == null) {
				query.append(_FINDER_COLUMN_URI_URI_1);
			}
			else if (uri.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URI_URI_3);
			}
			else {
				bindUri = true;

				query.append(_FINDER_COLUMN_URI_URI_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUri) {
					qPos.add(uri);
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

	private static final String _FINDER_COLUMN_URI_URI_1 = "jiraStatus.uri IS NULL";
	private static final String _FINDER_COLUMN_URI_URI_2 = "jiraStatus.uri = ?";
	private static final String _FINDER_COLUMN_URI_URI_3 = "(jiraStatus.uri IS NULL OR jiraStatus.uri = '')";

	public JiraStatusPersistenceImpl() {
		setModelClass(JiraStatus.class);
	}

	/**
	 * Caches the jira status in the entity cache if it is enabled.
	 *
	 * @param jiraStatus the jira status
	 */
	@Override
	public void cacheResult(JiraStatus jiraStatus) {
		EntityCacheUtil.putResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusImpl.class, jiraStatus.getPrimaryKey(), jiraStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
			new Object[] { jiraStatus.getName() }, jiraStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
			new Object[] { jiraStatus.getUri() }, jiraStatus);

		jiraStatus.resetOriginalValues();
	}

	/**
	 * Caches the jira statuses in the entity cache if it is enabled.
	 *
	 * @param jiraStatuses the jira statuses
	 */
	@Override
	public void cacheResult(List<JiraStatus> jiraStatuses) {
		for (JiraStatus jiraStatus : jiraStatuses) {
			if (EntityCacheUtil.getResult(
						JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
						JiraStatusImpl.class, jiraStatus.getPrimaryKey()) == null) {
				cacheResult(jiraStatus);
			}
			else {
				jiraStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jira statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JiraStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JiraStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jira status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JiraStatus jiraStatus) {
		EntityCacheUtil.removeResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusImpl.class, jiraStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(jiraStatus);
	}

	@Override
	public void clearCache(List<JiraStatus> jiraStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JiraStatus jiraStatus : jiraStatuses) {
			EntityCacheUtil.removeResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
				JiraStatusImpl.class, jiraStatus.getPrimaryKey());

			clearUniqueFindersCache(jiraStatus);
		}
	}

	protected void cacheUniqueFindersCache(JiraStatus jiraStatus) {
		if (jiraStatus.isNew()) {
			Object[] args = new Object[] { jiraStatus.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
				jiraStatus);

			args = new Object[] { jiraStatus.getUri() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URI, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI, args, jiraStatus);
		}
		else {
			JiraStatusModelImpl jiraStatusModelImpl = (JiraStatusModelImpl)jiraStatus;

			if ((jiraStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraStatus.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
					jiraStatus);
			}

			if ((jiraStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_URI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraStatus.getUri() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URI, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI, args,
					jiraStatus);
			}
		}
	}

	protected void clearUniqueFindersCache(JiraStatus jiraStatus) {
		JiraStatusModelImpl jiraStatusModelImpl = (JiraStatusModelImpl)jiraStatus;

		Object[] args = new Object[] { jiraStatus.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);

		if ((jiraStatusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
			args = new Object[] { jiraStatusModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);
		}

		args = new Object[] { jiraStatus.getUri() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URI, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI, args);

		if ((jiraStatusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_URI.getColumnBitmask()) != 0) {
			args = new Object[] { jiraStatusModelImpl.getOriginalUri() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URI, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI, args);
		}
	}

	/**
	 * Creates a new jira status with the primary key. Does not add the jira status to the database.
	 *
	 * @param jiraStatusId the primary key for the new jira status
	 * @return the new jira status
	 */
	@Override
	public JiraStatus create(long jiraStatusId) {
		JiraStatus jiraStatus = new JiraStatusImpl();

		jiraStatus.setNew(true);
		jiraStatus.setPrimaryKey(jiraStatusId);

		return jiraStatus;
	}

	/**
	 * Removes the jira status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraStatusId the primary key of the jira status
	 * @return the jira status that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus remove(long jiraStatusId)
		throws NoSuchJiraStatusException, SystemException {
		return remove((Serializable)jiraStatusId);
	}

	/**
	 * Removes the jira status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jira status
	 * @return the jira status that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus remove(Serializable primaryKey)
		throws NoSuchJiraStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JiraStatus jiraStatus = (JiraStatus)session.get(JiraStatusImpl.class,
					primaryKey);

			if (jiraStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJiraStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jiraStatus);
		}
		catch (NoSuchJiraStatusException nsee) {
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
	protected JiraStatus removeImpl(JiraStatus jiraStatus)
		throws SystemException {
		jiraStatus = toUnwrappedModel(jiraStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jiraStatus)) {
				jiraStatus = (JiraStatus)session.get(JiraStatusImpl.class,
						jiraStatus.getPrimaryKeyObj());
			}

			if (jiraStatus != null) {
				session.delete(jiraStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jiraStatus != null) {
			clearCache(jiraStatus);
		}

		return jiraStatus;
	}

	@Override
	public JiraStatus updateImpl(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus)
		throws SystemException {
		jiraStatus = toUnwrappedModel(jiraStatus);

		boolean isNew = jiraStatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jiraStatus.isNew()) {
				session.save(jiraStatus);

				jiraStatus.setNew(false);
			}
			else {
				session.merge(jiraStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JiraStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
			JiraStatusImpl.class, jiraStatus.getPrimaryKey(), jiraStatus);

		clearUniqueFindersCache(jiraStatus);
		cacheUniqueFindersCache(jiraStatus);

		return jiraStatus;
	}

	protected JiraStatus toUnwrappedModel(JiraStatus jiraStatus) {
		if (jiraStatus instanceof JiraStatusImpl) {
			return jiraStatus;
		}

		JiraStatusImpl jiraStatusImpl = new JiraStatusImpl();

		jiraStatusImpl.setNew(jiraStatus.isNew());
		jiraStatusImpl.setPrimaryKey(jiraStatus.getPrimaryKey());

		jiraStatusImpl.setJiraStatusId(jiraStatus.getJiraStatusId());
		jiraStatusImpl.setCreateDate(jiraStatus.getCreateDate());
		jiraStatusImpl.setModifiedDate(jiraStatus.getModifiedDate());
		jiraStatusImpl.setUri(jiraStatus.getUri());
		jiraStatusImpl.setName(jiraStatus.getName());

		return jiraStatusImpl;
	}

	/**
	 * Returns the jira status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira status
	 * @return the jira status
	 * @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJiraStatusException, SystemException {
		JiraStatus jiraStatus = fetchByPrimaryKey(primaryKey);

		if (jiraStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJiraStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jiraStatus;
	}

	/**
	 * Returns the jira status with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	 *
	 * @param jiraStatusId the primary key of the jira status
	 * @return the jira status
	 * @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus findByPrimaryKey(long jiraStatusId)
		throws NoSuchJiraStatusException, SystemException {
		return findByPrimaryKey((Serializable)jiraStatusId);
	}

	/**
	 * Returns the jira status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira status
	 * @return the jira status, or <code>null</code> if a jira status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JiraStatus jiraStatus = (JiraStatus)EntityCacheUtil.getResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
				JiraStatusImpl.class, primaryKey);

		if (jiraStatus == _nullJiraStatus) {
			return null;
		}

		if (jiraStatus == null) {
			Session session = null;

			try {
				session = openSession();

				jiraStatus = (JiraStatus)session.get(JiraStatusImpl.class,
						primaryKey);

				if (jiraStatus != null) {
					cacheResult(jiraStatus);
				}
				else {
					EntityCacheUtil.putResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
						JiraStatusImpl.class, primaryKey, _nullJiraStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JiraStatusModelImpl.ENTITY_CACHE_ENABLED,
					JiraStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jiraStatus;
	}

	/**
	 * Returns the jira status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jiraStatusId the primary key of the jira status
	 * @return the jira status, or <code>null</code> if a jira status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraStatus fetchByPrimaryKey(long jiraStatusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jiraStatusId);
	}

	/**
	 * Returns all the jira statuses.
	 *
	 * @return the jira statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira statuses
	 * @param end the upper bound of the range of jira statuses (not inclusive)
	 * @return the range of jira statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira statuses
	 * @param end the upper bound of the range of jira statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jira statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraStatus> findAll(int start, int end,
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

		List<JiraStatus> list = (List<JiraStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JIRASTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JIRASTATUS;

				if (pagination) {
					sql = sql.concat(JiraStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JiraStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraStatus>(list);
				}
				else {
					list = (List<JiraStatus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the jira statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JiraStatus jiraStatus : findAll()) {
			remove(jiraStatus);
		}
	}

	/**
	 * Returns the number of jira statuses.
	 *
	 * @return the number of jira statuses
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

				Query q = session.createQuery(_SQL_COUNT_JIRASTATUS);

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

	/**
	 * Initializes the jira status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.jira.metrics.model.JiraStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JiraStatus>> listenersList = new ArrayList<ModelListener<JiraStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JiraStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JiraStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JIRASTATUS = "SELECT jiraStatus FROM JiraStatus jiraStatus";
	private static final String _SQL_SELECT_JIRASTATUS_WHERE = "SELECT jiraStatus FROM JiraStatus jiraStatus WHERE ";
	private static final String _SQL_COUNT_JIRASTATUS = "SELECT COUNT(jiraStatus) FROM JiraStatus jiraStatus";
	private static final String _SQL_COUNT_JIRASTATUS_WHERE = "SELECT COUNT(jiraStatus) FROM JiraStatus jiraStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JiraStatusPersistenceImpl.class);
	private static JiraStatus _nullJiraStatus = new JiraStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JiraStatus> toCacheModel() {
				return _nullJiraStatusCacheModel;
			}
		};

	private static CacheModel<JiraStatus> _nullJiraStatusCacheModel = new CacheModel<JiraStatus>() {
			@Override
			public JiraStatus toEntityModel() {
				return _nullJiraStatus;
			}
		};
}