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

import com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;
import com.liferay.jira.metrics.model.JiraDataRetrieve;
import com.liferay.jira.metrics.model.impl.JiraDataRetrieveImpl;
import com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the jira data retrieve service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrievePersistence
 * @see JiraDataRetrieveUtil
 * @generated
 */
public class JiraDataRetrievePersistenceImpl extends BasePersistenceImpl<JiraDataRetrieve>
	implements JiraDataRetrievePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JiraDataRetrieveUtil} to access the jira data retrieve persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JiraDataRetrieveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveModelImpl.FINDER_CACHE_ENABLED,
			JiraDataRetrieveImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveModelImpl.FINDER_CACHE_ENABLED,
			JiraDataRetrieveImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_D_M_Y = new FinderPath(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveModelImpl.FINDER_CACHE_ENABLED,
			JiraDataRetrieveImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByD_M_Y",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			JiraDataRetrieveModelImpl.DAY_COLUMN_BITMASK |
			JiraDataRetrieveModelImpl.MONTH_COLUMN_BITMASK |
			JiraDataRetrieveModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_M_Y = new FinderPath(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_M_Y",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraDataRetrieveException} if it could not be found.
	 *
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the matching jira data retrieve
	 * @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve findByD_M_Y(int day, int month, int year)
		throws NoSuchJiraDataRetrieveException, SystemException {
		JiraDataRetrieve jiraDataRetrieve = fetchByD_M_Y(day, month, year);

		if (jiraDataRetrieve == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("day=");
			msg.append(day);

			msg.append(", month=");
			msg.append(month);

			msg.append(", year=");
			msg.append(year);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraDataRetrieveException(msg.toString());
		}

		return jiraDataRetrieve;
	}

	/**
	 * Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve fetchByD_M_Y(int day, int month, int year)
		throws SystemException {
		return fetchByD_M_Y(day, month, year, true);
	}

	/**
	 * Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve fetchByD_M_Y(int day, int month, int year,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { day, month, year };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_D_M_Y,
					finderArgs, this);
		}

		if (result instanceof JiraDataRetrieve) {
			JiraDataRetrieve jiraDataRetrieve = (JiraDataRetrieve)result;

			if ((day != jiraDataRetrieve.getDay()) ||
					(month != jiraDataRetrieve.getMonth()) ||
					(year != jiraDataRetrieve.getYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_JIRADATARETRIEVE_WHERE);

			query.append(_FINDER_COLUMN_D_M_Y_DAY_2);

			query.append(_FINDER_COLUMN_D_M_Y_MONTH_2);

			query.append(_FINDER_COLUMN_D_M_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(day);

				qPos.add(month);

				qPos.add(year);

				List<JiraDataRetrieve> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_M_Y,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"JiraDataRetrievePersistenceImpl.fetchByD_M_Y(int, int, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					JiraDataRetrieve jiraDataRetrieve = list.get(0);

					result = jiraDataRetrieve;

					cacheResult(jiraDataRetrieve);

					if ((jiraDataRetrieve.getDay() != day) ||
							(jiraDataRetrieve.getMonth() != month) ||
							(jiraDataRetrieve.getYear() != year)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_M_Y,
							finderArgs, jiraDataRetrieve);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_M_Y,
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
			return (JiraDataRetrieve)result;
		}
	}

	/**
	 * Removes the jira data retrieve where day = &#63; and month = &#63; and year = &#63; from the database.
	 *
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the jira data retrieve that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve removeByD_M_Y(int day, int month, int year)
		throws NoSuchJiraDataRetrieveException, SystemException {
		JiraDataRetrieve jiraDataRetrieve = findByD_M_Y(day, month, year);

		return remove(jiraDataRetrieve);
	}

	/**
	 * Returns the number of jira data retrieves where day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the number of matching jira data retrieves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_M_Y(int day, int month, int year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_M_Y;

		Object[] finderArgs = new Object[] { day, month, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JIRADATARETRIEVE_WHERE);

			query.append(_FINDER_COLUMN_D_M_Y_DAY_2);

			query.append(_FINDER_COLUMN_D_M_Y_MONTH_2);

			query.append(_FINDER_COLUMN_D_M_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(day);

				qPos.add(month);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_D_M_Y_DAY_2 = "jiraDataRetrieve.day = ? AND ";
	private static final String _FINDER_COLUMN_D_M_Y_MONTH_2 = "jiraDataRetrieve.month = ? AND ";
	private static final String _FINDER_COLUMN_D_M_Y_YEAR_2 = "jiraDataRetrieve.year = ?";

	public JiraDataRetrievePersistenceImpl() {
		setModelClass(JiraDataRetrieve.class);
	}

	/**
	 * Caches the jira data retrieve in the entity cache if it is enabled.
	 *
	 * @param jiraDataRetrieve the jira data retrieve
	 */
	@Override
	public void cacheResult(JiraDataRetrieve jiraDataRetrieve) {
		EntityCacheUtil.putResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveImpl.class, jiraDataRetrieve.getPrimaryKey(),
			jiraDataRetrieve);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_M_Y,
			new Object[] {
				jiraDataRetrieve.getDay(), jiraDataRetrieve.getMonth(),
				jiraDataRetrieve.getYear()
			}, jiraDataRetrieve);

		jiraDataRetrieve.resetOriginalValues();
	}

	/**
	 * Caches the jira data retrieves in the entity cache if it is enabled.
	 *
	 * @param jiraDataRetrieves the jira data retrieves
	 */
	@Override
	public void cacheResult(List<JiraDataRetrieve> jiraDataRetrieves) {
		for (JiraDataRetrieve jiraDataRetrieve : jiraDataRetrieves) {
			if (EntityCacheUtil.getResult(
						JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
						JiraDataRetrieveImpl.class,
						jiraDataRetrieve.getPrimaryKey()) == null) {
				cacheResult(jiraDataRetrieve);
			}
			else {
				jiraDataRetrieve.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jira data retrieves.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JiraDataRetrieveImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JiraDataRetrieveImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jira data retrieve.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JiraDataRetrieve jiraDataRetrieve) {
		EntityCacheUtil.removeResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveImpl.class, jiraDataRetrieve.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(jiraDataRetrieve);
	}

	@Override
	public void clearCache(List<JiraDataRetrieve> jiraDataRetrieves) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JiraDataRetrieve jiraDataRetrieve : jiraDataRetrieves) {
			EntityCacheUtil.removeResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
				JiraDataRetrieveImpl.class, jiraDataRetrieve.getPrimaryKey());

			clearUniqueFindersCache(jiraDataRetrieve);
		}
	}

	protected void cacheUniqueFindersCache(JiraDataRetrieve jiraDataRetrieve) {
		if (jiraDataRetrieve.isNew()) {
			Object[] args = new Object[] {
					jiraDataRetrieve.getDay(), jiraDataRetrieve.getMonth(),
					jiraDataRetrieve.getYear()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_M_Y, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_M_Y, args,
				jiraDataRetrieve);
		}
		else {
			JiraDataRetrieveModelImpl jiraDataRetrieveModelImpl = (JiraDataRetrieveModelImpl)jiraDataRetrieve;

			if ((jiraDataRetrieveModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_D_M_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jiraDataRetrieve.getDay(), jiraDataRetrieve.getMonth(),
						jiraDataRetrieve.getYear()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_M_Y, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_M_Y, args,
					jiraDataRetrieve);
			}
		}
	}

	protected void clearUniqueFindersCache(JiraDataRetrieve jiraDataRetrieve) {
		JiraDataRetrieveModelImpl jiraDataRetrieveModelImpl = (JiraDataRetrieveModelImpl)jiraDataRetrieve;

		Object[] args = new Object[] {
				jiraDataRetrieve.getDay(), jiraDataRetrieve.getMonth(),
				jiraDataRetrieve.getYear()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_M_Y, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_M_Y, args);

		if ((jiraDataRetrieveModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_D_M_Y.getColumnBitmask()) != 0) {
			args = new Object[] {
					jiraDataRetrieveModelImpl.getOriginalDay(),
					jiraDataRetrieveModelImpl.getOriginalMonth(),
					jiraDataRetrieveModelImpl.getOriginalYear()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_M_Y, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_M_Y, args);
		}
	}

	/**
	 * Creates a new jira data retrieve with the primary key. Does not add the jira data retrieve to the database.
	 *
	 * @param jiraDataRetrieveId the primary key for the new jira data retrieve
	 * @return the new jira data retrieve
	 */
	@Override
	public JiraDataRetrieve create(long jiraDataRetrieveId) {
		JiraDataRetrieve jiraDataRetrieve = new JiraDataRetrieveImpl();

		jiraDataRetrieve.setNew(true);
		jiraDataRetrieve.setPrimaryKey(jiraDataRetrieveId);

		return jiraDataRetrieve;
	}

	/**
	 * Removes the jira data retrieve with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraDataRetrieveId the primary key of the jira data retrieve
	 * @return the jira data retrieve that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve remove(long jiraDataRetrieveId)
		throws NoSuchJiraDataRetrieveException, SystemException {
		return remove((Serializable)jiraDataRetrieveId);
	}

	/**
	 * Removes the jira data retrieve with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jira data retrieve
	 * @return the jira data retrieve that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve remove(Serializable primaryKey)
		throws NoSuchJiraDataRetrieveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JiraDataRetrieve jiraDataRetrieve = (JiraDataRetrieve)session.get(JiraDataRetrieveImpl.class,
					primaryKey);

			if (jiraDataRetrieve == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJiraDataRetrieveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jiraDataRetrieve);
		}
		catch (NoSuchJiraDataRetrieveException nsee) {
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
	protected JiraDataRetrieve removeImpl(JiraDataRetrieve jiraDataRetrieve)
		throws SystemException {
		jiraDataRetrieve = toUnwrappedModel(jiraDataRetrieve);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jiraDataRetrieve)) {
				jiraDataRetrieve = (JiraDataRetrieve)session.get(JiraDataRetrieveImpl.class,
						jiraDataRetrieve.getPrimaryKeyObj());
			}

			if (jiraDataRetrieve != null) {
				session.delete(jiraDataRetrieve);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jiraDataRetrieve != null) {
			clearCache(jiraDataRetrieve);
		}

		return jiraDataRetrieve;
	}

	@Override
	public JiraDataRetrieve updateImpl(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve)
		throws SystemException {
		jiraDataRetrieve = toUnwrappedModel(jiraDataRetrieve);

		boolean isNew = jiraDataRetrieve.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jiraDataRetrieve.isNew()) {
				session.save(jiraDataRetrieve);

				jiraDataRetrieve.setNew(false);
			}
			else {
				session.merge(jiraDataRetrieve);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JiraDataRetrieveModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
			JiraDataRetrieveImpl.class, jiraDataRetrieve.getPrimaryKey(),
			jiraDataRetrieve);

		clearUniqueFindersCache(jiraDataRetrieve);
		cacheUniqueFindersCache(jiraDataRetrieve);

		return jiraDataRetrieve;
	}

	protected JiraDataRetrieve toUnwrappedModel(
		JiraDataRetrieve jiraDataRetrieve) {
		if (jiraDataRetrieve instanceof JiraDataRetrieveImpl) {
			return jiraDataRetrieve;
		}

		JiraDataRetrieveImpl jiraDataRetrieveImpl = new JiraDataRetrieveImpl();

		jiraDataRetrieveImpl.setNew(jiraDataRetrieve.isNew());
		jiraDataRetrieveImpl.setPrimaryKey(jiraDataRetrieve.getPrimaryKey());

		jiraDataRetrieveImpl.setJiraDataRetrieveId(jiraDataRetrieve.getJiraDataRetrieveId());
		jiraDataRetrieveImpl.setCreateDate(jiraDataRetrieve.getCreateDate());
		jiraDataRetrieveImpl.setModifiedDate(jiraDataRetrieve.getModifiedDate());
		jiraDataRetrieveImpl.setStatus(jiraDataRetrieve.getStatus());
		jiraDataRetrieveImpl.setStatusDescription(jiraDataRetrieve.getStatusDescription());
		jiraDataRetrieveImpl.setDay(jiraDataRetrieve.getDay());
		jiraDataRetrieveImpl.setMonth(jiraDataRetrieve.getMonth());
		jiraDataRetrieveImpl.setYear(jiraDataRetrieve.getYear());

		return jiraDataRetrieveImpl;
	}

	/**
	 * Returns the jira data retrieve with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira data retrieve
	 * @return the jira data retrieve
	 * @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJiraDataRetrieveException, SystemException {
		JiraDataRetrieve jiraDataRetrieve = fetchByPrimaryKey(primaryKey);

		if (jiraDataRetrieve == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJiraDataRetrieveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jiraDataRetrieve;
	}

	/**
	 * Returns the jira data retrieve with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraDataRetrieveException} if it could not be found.
	 *
	 * @param jiraDataRetrieveId the primary key of the jira data retrieve
	 * @return the jira data retrieve
	 * @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve findByPrimaryKey(long jiraDataRetrieveId)
		throws NoSuchJiraDataRetrieveException, SystemException {
		return findByPrimaryKey((Serializable)jiraDataRetrieveId);
	}

	/**
	 * Returns the jira data retrieve with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira data retrieve
	 * @return the jira data retrieve, or <code>null</code> if a jira data retrieve with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JiraDataRetrieve jiraDataRetrieve = (JiraDataRetrieve)EntityCacheUtil.getResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
				JiraDataRetrieveImpl.class, primaryKey);

		if (jiraDataRetrieve == _nullJiraDataRetrieve) {
			return null;
		}

		if (jiraDataRetrieve == null) {
			Session session = null;

			try {
				session = openSession();

				jiraDataRetrieve = (JiraDataRetrieve)session.get(JiraDataRetrieveImpl.class,
						primaryKey);

				if (jiraDataRetrieve != null) {
					cacheResult(jiraDataRetrieve);
				}
				else {
					EntityCacheUtil.putResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
						JiraDataRetrieveImpl.class, primaryKey,
						_nullJiraDataRetrieve);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JiraDataRetrieveModelImpl.ENTITY_CACHE_ENABLED,
					JiraDataRetrieveImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jiraDataRetrieve;
	}

	/**
	 * Returns the jira data retrieve with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jiraDataRetrieveId the primary key of the jira data retrieve
	 * @return the jira data retrieve, or <code>null</code> if a jira data retrieve with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraDataRetrieve fetchByPrimaryKey(long jiraDataRetrieveId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jiraDataRetrieveId);
	}

	/**
	 * Returns all the jira data retrieves.
	 *
	 * @return the jira data retrieves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraDataRetrieve> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira data retrieves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira data retrieves
	 * @param end the upper bound of the range of jira data retrieves (not inclusive)
	 * @return the range of jira data retrieves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraDataRetrieve> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira data retrieves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira data retrieves
	 * @param end the upper bound of the range of jira data retrieves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jira data retrieves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraDataRetrieve> findAll(int start, int end,
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

		List<JiraDataRetrieve> list = (List<JiraDataRetrieve>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JIRADATARETRIEVE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JIRADATARETRIEVE;

				if (pagination) {
					sql = sql.concat(JiraDataRetrieveModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JiraDataRetrieve>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraDataRetrieve>(list);
				}
				else {
					list = (List<JiraDataRetrieve>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the jira data retrieves from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JiraDataRetrieve jiraDataRetrieve : findAll()) {
			remove(jiraDataRetrieve);
		}
	}

	/**
	 * Returns the number of jira data retrieves.
	 *
	 * @return the number of jira data retrieves
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

				Query q = session.createQuery(_SQL_COUNT_JIRADATARETRIEVE);

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
	 * Initializes the jira data retrieve persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.jira.metrics.model.JiraDataRetrieve")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JiraDataRetrieve>> listenersList = new ArrayList<ModelListener<JiraDataRetrieve>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JiraDataRetrieve>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JiraDataRetrieveImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JIRADATARETRIEVE = "SELECT jiraDataRetrieve FROM JiraDataRetrieve jiraDataRetrieve";
	private static final String _SQL_SELECT_JIRADATARETRIEVE_WHERE = "SELECT jiraDataRetrieve FROM JiraDataRetrieve jiraDataRetrieve WHERE ";
	private static final String _SQL_COUNT_JIRADATARETRIEVE = "SELECT COUNT(jiraDataRetrieve) FROM JiraDataRetrieve jiraDataRetrieve";
	private static final String _SQL_COUNT_JIRADATARETRIEVE_WHERE = "SELECT COUNT(jiraDataRetrieve) FROM JiraDataRetrieve jiraDataRetrieve WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraDataRetrieve.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraDataRetrieve exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraDataRetrieve exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JiraDataRetrievePersistenceImpl.class);
	private static JiraDataRetrieve _nullJiraDataRetrieve = new JiraDataRetrieveImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JiraDataRetrieve> toCacheModel() {
				return _nullJiraDataRetrieveCacheModel;
			}
		};

	private static CacheModel<JiraDataRetrieve> _nullJiraDataRetrieveCacheModel = new CacheModel<JiraDataRetrieve>() {
			@Override
			public JiraDataRetrieve toEntityModel() {
				return _nullJiraDataRetrieve;
			}
		};
}