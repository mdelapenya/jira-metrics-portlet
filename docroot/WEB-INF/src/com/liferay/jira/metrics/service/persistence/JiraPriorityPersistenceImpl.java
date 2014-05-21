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

import com.liferay.jira.metrics.NoSuchJiraPriorityException;
import com.liferay.jira.metrics.model.JiraPriority;
import com.liferay.jira.metrics.model.impl.JiraPriorityImpl;
import com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl;

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
 * The persistence implementation for the jira priority service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraPriorityPersistence
 * @see JiraPriorityUtil
 * @generated
 */
public class JiraPriorityPersistenceImpl extends BasePersistenceImpl<JiraPriority>
	implements JiraPriorityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JiraPriorityUtil} to access the jira priority persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JiraPriorityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, JiraPriorityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, JiraPriorityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_VALUE = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, JiraPriorityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByValue",
			new String[] { String.class.getName() },
			JiraPriorityModelImpl.VALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VALUE = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByValue",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira priority where value = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraPriorityException} if it could not be found.
	 *
	 * @param value the value
	 * @return the matching jira priority
	 * @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a matching jira priority could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority findByValue(String value)
		throws NoSuchJiraPriorityException, SystemException {
		JiraPriority jiraPriority = fetchByValue(value);

		if (jiraPriority == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("value=");
			msg.append(value);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraPriorityException(msg.toString());
		}

		return jiraPriority;
	}

	/**
	 * Returns the jira priority where value = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param value the value
	 * @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority fetchByValue(String value) throws SystemException {
		return fetchByValue(value, true);
	}

	/**
	 * Returns the jira priority where value = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param value the value
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority fetchByValue(String value, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { value };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VALUE,
					finderArgs, this);
		}

		if (result instanceof JiraPriority) {
			JiraPriority jiraPriority = (JiraPriority)result;

			if (!Validator.equals(value, jiraPriority.getValue())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRAPRIORITY_WHERE);

			boolean bindValue = false;

			if (value == null) {
				query.append(_FINDER_COLUMN_VALUE_VALUE_1);
			}
			else if (value.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VALUE_VALUE_3);
			}
			else {
				bindValue = true;

				query.append(_FINDER_COLUMN_VALUE_VALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindValue) {
					qPos.add(value);
				}

				List<JiraPriority> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUE,
						finderArgs, list);
				}
				else {
					JiraPriority jiraPriority = list.get(0);

					result = jiraPriority;

					cacheResult(jiraPriority);

					if ((jiraPriority.getValue() == null) ||
							!jiraPriority.getValue().equals(value)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUE,
							finderArgs, jiraPriority);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VALUE,
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
			return (JiraPriority)result;
		}
	}

	/**
	 * Removes the jira priority where value = &#63; from the database.
	 *
	 * @param value the value
	 * @return the jira priority that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority removeByValue(String value)
		throws NoSuchJiraPriorityException, SystemException {
		JiraPriority jiraPriority = findByValue(value);

		return remove(jiraPriority);
	}

	/**
	 * Returns the number of jira priorities where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching jira priorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByValue(String value) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VALUE;

		Object[] finderArgs = new Object[] { value };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JIRAPRIORITY_WHERE);

			boolean bindValue = false;

			if (value == null) {
				query.append(_FINDER_COLUMN_VALUE_VALUE_1);
			}
			else if (value.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VALUE_VALUE_3);
			}
			else {
				bindValue = true;

				query.append(_FINDER_COLUMN_VALUE_VALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindValue) {
					qPos.add(value);
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

	private static final String _FINDER_COLUMN_VALUE_VALUE_1 = "jiraPriority.value IS NULL";
	private static final String _FINDER_COLUMN_VALUE_VALUE_2 = "jiraPriority.value = ?";
	private static final String _FINDER_COLUMN_VALUE_VALUE_3 = "(jiraPriority.value IS NULL OR jiraPriority.value = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, JiraPriorityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			JiraPriorityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira priority where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraPriorityException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching jira priority
	 * @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a matching jira priority could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority findByName(String name)
		throws NoSuchJiraPriorityException, SystemException {
		JiraPriority jiraPriority = fetchByName(name);

		if (jiraPriority == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraPriorityException(msg.toString());
		}

		return jiraPriority;
	}

	/**
	 * Returns the jira priority where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the jira priority where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof JiraPriority) {
			JiraPriority jiraPriority = (JiraPriority)result;

			if (!Validator.equals(name, jiraPriority.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRAPRIORITY_WHERE);

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

				List<JiraPriority> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					JiraPriority jiraPriority = list.get(0);

					result = jiraPriority;

					cacheResult(jiraPriority);

					if ((jiraPriority.getName() == null) ||
							!jiraPriority.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, jiraPriority);
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
			return (JiraPriority)result;
		}
	}

	/**
	 * Removes the jira priority where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the jira priority that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority removeByName(String name)
		throws NoSuchJiraPriorityException, SystemException {
		JiraPriority jiraPriority = findByName(name);

		return remove(jiraPriority);
	}

	/**
	 * Returns the number of jira priorities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching jira priorities
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

			query.append(_SQL_COUNT_JIRAPRIORITY_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "jiraPriority.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "jiraPriority.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(jiraPriority.name IS NULL OR jiraPriority.name = '')";

	public JiraPriorityPersistenceImpl() {
		setModelClass(JiraPriority.class);
	}

	/**
	 * Caches the jira priority in the entity cache if it is enabled.
	 *
	 * @param jiraPriority the jira priority
	 */
	@Override
	public void cacheResult(JiraPriority jiraPriority) {
		EntityCacheUtil.putResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityImpl.class, jiraPriority.getPrimaryKey(), jiraPriority);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUE,
			new Object[] { jiraPriority.getValue() }, jiraPriority);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { jiraPriority.getName() }, jiraPriority);

		jiraPriority.resetOriginalValues();
	}

	/**
	 * Caches the jira priorities in the entity cache if it is enabled.
	 *
	 * @param jiraPriorities the jira priorities
	 */
	@Override
	public void cacheResult(List<JiraPriority> jiraPriorities) {
		for (JiraPriority jiraPriority : jiraPriorities) {
			if (EntityCacheUtil.getResult(
						JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
						JiraPriorityImpl.class, jiraPriority.getPrimaryKey()) == null) {
				cacheResult(jiraPriority);
			}
			else {
				jiraPriority.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jira priorities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JiraPriorityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JiraPriorityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jira priority.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JiraPriority jiraPriority) {
		EntityCacheUtil.removeResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityImpl.class, jiraPriority.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(jiraPriority);
	}

	@Override
	public void clearCache(List<JiraPriority> jiraPriorities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JiraPriority jiraPriority : jiraPriorities) {
			EntityCacheUtil.removeResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
				JiraPriorityImpl.class, jiraPriority.getPrimaryKey());

			clearUniqueFindersCache(jiraPriority);
		}
	}

	protected void cacheUniqueFindersCache(JiraPriority jiraPriority) {
		if (jiraPriority.isNew()) {
			Object[] args = new Object[] { jiraPriority.getValue() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VALUE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUE, args,
				jiraPriority);

			args = new Object[] { jiraPriority.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				jiraPriority);
		}
		else {
			JiraPriorityModelImpl jiraPriorityModelImpl = (JiraPriorityModelImpl)jiraPriority;

			if ((jiraPriorityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VALUE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraPriority.getValue() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VALUE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VALUE, args,
					jiraPriority);
			}

			if ((jiraPriorityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraPriority.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					jiraPriority);
			}
		}
	}

	protected void clearUniqueFindersCache(JiraPriority jiraPriority) {
		JiraPriorityModelImpl jiraPriorityModelImpl = (JiraPriorityModelImpl)jiraPriority;

		Object[] args = new Object[] { jiraPriority.getValue() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VALUE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VALUE, args);

		if ((jiraPriorityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VALUE.getColumnBitmask()) != 0) {
			args = new Object[] { jiraPriorityModelImpl.getOriginalValue() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VALUE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VALUE, args);
		}

		args = new Object[] { jiraPriority.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((jiraPriorityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { jiraPriorityModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new jira priority with the primary key. Does not add the jira priority to the database.
	 *
	 * @param jiraPriorityId the primary key for the new jira priority
	 * @return the new jira priority
	 */
	@Override
	public JiraPriority create(long jiraPriorityId) {
		JiraPriority jiraPriority = new JiraPriorityImpl();

		jiraPriority.setNew(true);
		jiraPriority.setPrimaryKey(jiraPriorityId);

		return jiraPriority;
	}

	/**
	 * Removes the jira priority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraPriorityId the primary key of the jira priority
	 * @return the jira priority that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a jira priority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority remove(long jiraPriorityId)
		throws NoSuchJiraPriorityException, SystemException {
		return remove((Serializable)jiraPriorityId);
	}

	/**
	 * Removes the jira priority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jira priority
	 * @return the jira priority that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a jira priority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority remove(Serializable primaryKey)
		throws NoSuchJiraPriorityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JiraPriority jiraPriority = (JiraPriority)session.get(JiraPriorityImpl.class,
					primaryKey);

			if (jiraPriority == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJiraPriorityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jiraPriority);
		}
		catch (NoSuchJiraPriorityException nsee) {
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
	protected JiraPriority removeImpl(JiraPriority jiraPriority)
		throws SystemException {
		jiraPriority = toUnwrappedModel(jiraPriority);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jiraPriority)) {
				jiraPriority = (JiraPriority)session.get(JiraPriorityImpl.class,
						jiraPriority.getPrimaryKeyObj());
			}

			if (jiraPriority != null) {
				session.delete(jiraPriority);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jiraPriority != null) {
			clearCache(jiraPriority);
		}

		return jiraPriority;
	}

	@Override
	public JiraPriority updateImpl(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority)
		throws SystemException {
		jiraPriority = toUnwrappedModel(jiraPriority);

		boolean isNew = jiraPriority.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jiraPriority.isNew()) {
				session.save(jiraPriority);

				jiraPriority.setNew(false);
			}
			else {
				session.merge(jiraPriority);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JiraPriorityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
			JiraPriorityImpl.class, jiraPriority.getPrimaryKey(), jiraPriority);

		clearUniqueFindersCache(jiraPriority);
		cacheUniqueFindersCache(jiraPriority);

		return jiraPriority;
	}

	protected JiraPriority toUnwrappedModel(JiraPriority jiraPriority) {
		if (jiraPriority instanceof JiraPriorityImpl) {
			return jiraPriority;
		}

		JiraPriorityImpl jiraPriorityImpl = new JiraPriorityImpl();

		jiraPriorityImpl.setNew(jiraPriority.isNew());
		jiraPriorityImpl.setPrimaryKey(jiraPriority.getPrimaryKey());

		jiraPriorityImpl.setJiraPriorityId(jiraPriority.getJiraPriorityId());
		jiraPriorityImpl.setCreateDate(jiraPriority.getCreateDate());
		jiraPriorityImpl.setModifiedDate(jiraPriority.getModifiedDate());
		jiraPriorityImpl.setValue(jiraPriority.getValue());
		jiraPriorityImpl.setName(jiraPriority.getName());

		return jiraPriorityImpl;
	}

	/**
	 * Returns the jira priority with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira priority
	 * @return the jira priority
	 * @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a jira priority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJiraPriorityException, SystemException {
		JiraPriority jiraPriority = fetchByPrimaryKey(primaryKey);

		if (jiraPriority == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJiraPriorityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jiraPriority;
	}

	/**
	 * Returns the jira priority with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraPriorityException} if it could not be found.
	 *
	 * @param jiraPriorityId the primary key of the jira priority
	 * @return the jira priority
	 * @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a jira priority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority findByPrimaryKey(long jiraPriorityId)
		throws NoSuchJiraPriorityException, SystemException {
		return findByPrimaryKey((Serializable)jiraPriorityId);
	}

	/**
	 * Returns the jira priority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira priority
	 * @return the jira priority, or <code>null</code> if a jira priority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JiraPriority jiraPriority = (JiraPriority)EntityCacheUtil.getResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
				JiraPriorityImpl.class, primaryKey);

		if (jiraPriority == _nullJiraPriority) {
			return null;
		}

		if (jiraPriority == null) {
			Session session = null;

			try {
				session = openSession();

				jiraPriority = (JiraPriority)session.get(JiraPriorityImpl.class,
						primaryKey);

				if (jiraPriority != null) {
					cacheResult(jiraPriority);
				}
				else {
					EntityCacheUtil.putResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
						JiraPriorityImpl.class, primaryKey, _nullJiraPriority);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JiraPriorityModelImpl.ENTITY_CACHE_ENABLED,
					JiraPriorityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jiraPriority;
	}

	/**
	 * Returns the jira priority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jiraPriorityId the primary key of the jira priority
	 * @return the jira priority, or <code>null</code> if a jira priority with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraPriority fetchByPrimaryKey(long jiraPriorityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jiraPriorityId);
	}

	/**
	 * Returns all the jira priorities.
	 *
	 * @return the jira priorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraPriority> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira priorities
	 * @param end the upper bound of the range of jira priorities (not inclusive)
	 * @return the range of jira priorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraPriority> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira priorities
	 * @param end the upper bound of the range of jira priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jira priorities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraPriority> findAll(int start, int end,
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

		List<JiraPriority> list = (List<JiraPriority>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JIRAPRIORITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JIRAPRIORITY;

				if (pagination) {
					sql = sql.concat(JiraPriorityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JiraPriority>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraPriority>(list);
				}
				else {
					list = (List<JiraPriority>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the jira priorities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JiraPriority jiraPriority : findAll()) {
			remove(jiraPriority);
		}
	}

	/**
	 * Returns the number of jira priorities.
	 *
	 * @return the number of jira priorities
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

				Query q = session.createQuery(_SQL_COUNT_JIRAPRIORITY);

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
	 * Initializes the jira priority persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.jira.metrics.model.JiraPriority")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JiraPriority>> listenersList = new ArrayList<ModelListener<JiraPriority>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JiraPriority>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JiraPriorityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JIRAPRIORITY = "SELECT jiraPriority FROM JiraPriority jiraPriority";
	private static final String _SQL_SELECT_JIRAPRIORITY_WHERE = "SELECT jiraPriority FROM JiraPriority jiraPriority WHERE ";
	private static final String _SQL_COUNT_JIRAPRIORITY = "SELECT COUNT(jiraPriority) FROM JiraPriority jiraPriority";
	private static final String _SQL_COUNT_JIRAPRIORITY_WHERE = "SELECT COUNT(jiraPriority) FROM JiraPriority jiraPriority WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraPriority.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraPriority exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraPriority exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JiraPriorityPersistenceImpl.class);
	private static JiraPriority _nullJiraPriority = new JiraPriorityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JiraPriority> toCacheModel() {
				return _nullJiraPriorityCacheModel;
			}
		};

	private static CacheModel<JiraPriority> _nullJiraPriorityCacheModel = new CacheModel<JiraPriority>() {
			@Override
			public JiraPriority toEntityModel() {
				return _nullJiraPriority;
			}
		};
}