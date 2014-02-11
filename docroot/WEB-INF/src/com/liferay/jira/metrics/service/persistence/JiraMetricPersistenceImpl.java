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

import com.liferay.jira.metrics.NoSuchJiraMetricException;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.model.impl.JiraMetricImpl;
import com.liferay.jira.metrics.model.impl.JiraMetricModelImpl;

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
 * The persistence implementation for the jira metric service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraMetricPersistence
 * @see JiraMetricUtil
 * @generated
 */
public class JiraMetricPersistenceImpl extends BasePersistenceImpl<JiraMetric>
	implements JiraMetricPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JiraMetricUtil} to access the jira metric persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JiraMetricImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricModelImpl.FINDER_CACHE_ENABLED, JiraMetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricModelImpl.FINDER_CACHE_ENABLED, JiraMetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_C_S_D_M_Y =
		new FinderPath(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricModelImpl.FINDER_CACHE_ENABLED, JiraMetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_C_S_D_M_Y",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_C_S_D_M_Y =
		new FinderPath(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricModelImpl.FINDER_CACHE_ENABLED, JiraMetricImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_C_S_D_M_Y",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			JiraMetricModelImpl.JIRAPROJECTID_COLUMN_BITMASK |
			JiraMetricModelImpl.JIRACOMPONENTID_COLUMN_BITMASK |
			JiraMetricModelImpl.JIRASTATUSID_COLUMN_BITMASK |
			JiraMetricModelImpl.DAY_COLUMN_BITMASK |
			JiraMetricModelImpl.MONTH_COLUMN_BITMASK |
			JiraMetricModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_C_S_D_M_Y = new FinderPath(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_C_S_D_M_Y",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the matching jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraMetric> findByP_C_S_D_M_Y(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year)
		throws SystemException {
		return findByP_C_S_D_M_Y(jiraProjectId, jiraComponentId, jiraStatusId,
			day, month, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of jira metrics
	 * @param end the upper bound of the range of jira metrics (not inclusive)
	 * @return the range of matching jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraMetric> findByP_C_S_D_M_Y(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year,
		int start, int end) throws SystemException {
		return findByP_C_S_D_M_Y(jiraProjectId, jiraComponentId, jiraStatusId,
			day, month, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of jira metrics
	 * @param end the upper bound of the range of jira metrics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraMetric> findByP_C_S_D_M_Y(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_C_S_D_M_Y;
			finderArgs = new Object[] {
					jiraProjectId, jiraComponentId, jiraStatusId, day, month,
					year
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_C_S_D_M_Y;
			finderArgs = new Object[] {
					jiraProjectId, jiraComponentId, jiraStatusId, day, month,
					year,
					
					start, end, orderByComparator
				};
		}

		List<JiraMetric> list = (List<JiraMetric>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JiraMetric jiraMetric : list) {
				if ((jiraProjectId != jiraMetric.getJiraProjectId()) ||
						(jiraComponentId != jiraMetric.getJiraComponentId()) ||
						(jiraStatusId != jiraMetric.getJiraStatusId()) ||
						(day != jiraMetric.getDay()) ||
						(month != jiraMetric.getMonth()) ||
						(year != jiraMetric.getYear())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_JIRAMETRIC_WHERE);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRAPROJECTID_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRACOMPONENTID_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRASTATUSID_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_DAY_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_MONTH_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JiraMetricModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jiraProjectId);

				qPos.add(jiraComponentId);

				qPos.add(jiraStatusId);

				qPos.add(day);

				qPos.add(month);

				qPos.add(year);

				if (!pagination) {
					list = (List<JiraMetric>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraMetric>(list);
				}
				else {
					list = (List<JiraMetric>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jira metric
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a matching jira metric could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric findByP_C_S_D_M_Y_First(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year,
		OrderByComparator orderByComparator)
		throws NoSuchJiraMetricException, SystemException {
		JiraMetric jiraMetric = fetchByP_C_S_D_M_Y_First(jiraProjectId,
				jiraComponentId, jiraStatusId, day, month, year,
				orderByComparator);

		if (jiraMetric != null) {
			return jiraMetric;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jiraProjectId=");
		msg.append(jiraProjectId);

		msg.append(", jiraComponentId=");
		msg.append(jiraComponentId);

		msg.append(", jiraStatusId=");
		msg.append(jiraStatusId);

		msg.append(", day=");
		msg.append(day);

		msg.append(", month=");
		msg.append(month);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJiraMetricException(msg.toString());
	}

	/**
	 * Returns the first jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jira metric, or <code>null</code> if a matching jira metric could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric fetchByP_C_S_D_M_Y_First(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<JiraMetric> list = findByP_C_S_D_M_Y(jiraProjectId,
				jiraComponentId, jiraStatusId, day, month, year, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jira metric
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a matching jira metric could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric findByP_C_S_D_M_Y_Last(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year,
		OrderByComparator orderByComparator)
		throws NoSuchJiraMetricException, SystemException {
		JiraMetric jiraMetric = fetchByP_C_S_D_M_Y_Last(jiraProjectId,
				jiraComponentId, jiraStatusId, day, month, year,
				orderByComparator);

		if (jiraMetric != null) {
			return jiraMetric;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jiraProjectId=");
		msg.append(jiraProjectId);

		msg.append(", jiraComponentId=");
		msg.append(jiraComponentId);

		msg.append(", jiraStatusId=");
		msg.append(jiraStatusId);

		msg.append(", day=");
		msg.append(day);

		msg.append(", month=");
		msg.append(month);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJiraMetricException(msg.toString());
	}

	/**
	 * Returns the last jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jira metric, or <code>null</code> if a matching jira metric could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric fetchByP_C_S_D_M_Y_Last(long jiraProjectId,
		long jiraComponentId, long jiraStatusId, int day, int month, int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByP_C_S_D_M_Y(jiraProjectId, jiraComponentId,
				jiraStatusId, day, month, year);

		if (count == 0) {
			return null;
		}

		List<JiraMetric> list = findByP_C_S_D_M_Y(jiraProjectId,
				jiraComponentId, jiraStatusId, day, month, year, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the jira metrics before and after the current jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraMetricId the primary key of the current jira metric
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next jira metric
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric[] findByP_C_S_D_M_Y_PrevAndNext(long jiraMetricId,
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year, OrderByComparator orderByComparator)
		throws NoSuchJiraMetricException, SystemException {
		JiraMetric jiraMetric = findByPrimaryKey(jiraMetricId);

		Session session = null;

		try {
			session = openSession();

			JiraMetric[] array = new JiraMetricImpl[3];

			array[0] = getByP_C_S_D_M_Y_PrevAndNext(session, jiraMetric,
					jiraProjectId, jiraComponentId, jiraStatusId, day, month,
					year, orderByComparator, true);

			array[1] = jiraMetric;

			array[2] = getByP_C_S_D_M_Y_PrevAndNext(session, jiraMetric,
					jiraProjectId, jiraComponentId, jiraStatusId, day, month,
					year, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JiraMetric getByP_C_S_D_M_Y_PrevAndNext(Session session,
		JiraMetric jiraMetric, long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int day, int month, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JIRAMETRIC_WHERE);

		query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRAPROJECTID_2);

		query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRACOMPONENTID_2);

		query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRASTATUSID_2);

		query.append(_FINDER_COLUMN_P_C_S_D_M_Y_DAY_2);

		query.append(_FINDER_COLUMN_P_C_S_D_M_Y_MONTH_2);

		query.append(_FINDER_COLUMN_P_C_S_D_M_Y_YEAR_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(JiraMetricModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jiraProjectId);

		qPos.add(jiraComponentId);

		qPos.add(jiraStatusId);

		qPos.add(day);

		qPos.add(month);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jiraMetric);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JiraMetric> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63; from the database.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByP_C_S_D_M_Y(long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int day, int month, int year)
		throws SystemException {
		for (JiraMetric jiraMetric : findByP_C_S_D_M_Y(jiraProjectId,
				jiraComponentId, jiraStatusId, day, month, year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jiraMetric);
		}
	}

	/**
	 * Returns the number of jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param jiraComponentId the jira component ID
	 * @param jiraStatusId the jira status ID
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the number of matching jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByP_C_S_D_M_Y(long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int day, int month, int year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_P_C_S_D_M_Y;

		Object[] finderArgs = new Object[] {
				jiraProjectId, jiraComponentId, jiraStatusId, day, month, year
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_JIRAMETRIC_WHERE);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRAPROJECTID_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRACOMPONENTID_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_JIRASTATUSID_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_DAY_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_MONTH_2);

			query.append(_FINDER_COLUMN_P_C_S_D_M_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jiraProjectId);

				qPos.add(jiraComponentId);

				qPos.add(jiraStatusId);

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

	private static final String _FINDER_COLUMN_P_C_S_D_M_Y_JIRAPROJECTID_2 = "jiraMetric.jiraProjectId = ? AND ";
	private static final String _FINDER_COLUMN_P_C_S_D_M_Y_JIRACOMPONENTID_2 = "jiraMetric.jiraComponentId = ? AND ";
	private static final String _FINDER_COLUMN_P_C_S_D_M_Y_JIRASTATUSID_2 = "jiraMetric.jiraStatusId = ? AND ";
	private static final String _FINDER_COLUMN_P_C_S_D_M_Y_DAY_2 = "jiraMetric.day = ? AND ";
	private static final String _FINDER_COLUMN_P_C_S_D_M_Y_MONTH_2 = "jiraMetric.month = ? AND ";
	private static final String _FINDER_COLUMN_P_C_S_D_M_Y_YEAR_2 = "jiraMetric.year = ?";

	public JiraMetricPersistenceImpl() {
		setModelClass(JiraMetric.class);
	}

	/**
	 * Caches the jira metric in the entity cache if it is enabled.
	 *
	 * @param jiraMetric the jira metric
	 */
	@Override
	public void cacheResult(JiraMetric jiraMetric) {
		EntityCacheUtil.putResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricImpl.class, jiraMetric.getPrimaryKey(), jiraMetric);

		jiraMetric.resetOriginalValues();
	}

	/**
	 * Caches the jira metrics in the entity cache if it is enabled.
	 *
	 * @param jiraMetrics the jira metrics
	 */
	@Override
	public void cacheResult(List<JiraMetric> jiraMetrics) {
		for (JiraMetric jiraMetric : jiraMetrics) {
			if (EntityCacheUtil.getResult(
						JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
						JiraMetricImpl.class, jiraMetric.getPrimaryKey()) == null) {
				cacheResult(jiraMetric);
			}
			else {
				jiraMetric.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jira metrics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JiraMetricImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JiraMetricImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jira metric.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JiraMetric jiraMetric) {
		EntityCacheUtil.removeResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricImpl.class, jiraMetric.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JiraMetric> jiraMetrics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JiraMetric jiraMetric : jiraMetrics) {
			EntityCacheUtil.removeResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
				JiraMetricImpl.class, jiraMetric.getPrimaryKey());
		}
	}

	/**
	 * Creates a new jira metric with the primary key. Does not add the jira metric to the database.
	 *
	 * @param jiraMetricId the primary key for the new jira metric
	 * @return the new jira metric
	 */
	@Override
	public JiraMetric create(long jiraMetricId) {
		JiraMetric jiraMetric = new JiraMetricImpl();

		jiraMetric.setNew(true);
		jiraMetric.setPrimaryKey(jiraMetricId);

		return jiraMetric;
	}

	/**
	 * Removes the jira metric with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraMetricId the primary key of the jira metric
	 * @return the jira metric that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric remove(long jiraMetricId)
		throws NoSuchJiraMetricException, SystemException {
		return remove((Serializable)jiraMetricId);
	}

	/**
	 * Removes the jira metric with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jira metric
	 * @return the jira metric that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric remove(Serializable primaryKey)
		throws NoSuchJiraMetricException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JiraMetric jiraMetric = (JiraMetric)session.get(JiraMetricImpl.class,
					primaryKey);

			if (jiraMetric == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJiraMetricException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jiraMetric);
		}
		catch (NoSuchJiraMetricException nsee) {
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
	protected JiraMetric removeImpl(JiraMetric jiraMetric)
		throws SystemException {
		jiraMetric = toUnwrappedModel(jiraMetric);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jiraMetric)) {
				jiraMetric = (JiraMetric)session.get(JiraMetricImpl.class,
						jiraMetric.getPrimaryKeyObj());
			}

			if (jiraMetric != null) {
				session.delete(jiraMetric);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jiraMetric != null) {
			clearCache(jiraMetric);
		}

		return jiraMetric;
	}

	@Override
	public JiraMetric updateImpl(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws SystemException {
		jiraMetric = toUnwrappedModel(jiraMetric);

		boolean isNew = jiraMetric.isNew();

		JiraMetricModelImpl jiraMetricModelImpl = (JiraMetricModelImpl)jiraMetric;

		Session session = null;

		try {
			session = openSession();

			if (jiraMetric.isNew()) {
				session.save(jiraMetric);

				jiraMetric.setNew(false);
			}
			else {
				session.merge(jiraMetric);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JiraMetricModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jiraMetricModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_C_S_D_M_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jiraMetricModelImpl.getOriginalJiraProjectId(),
						jiraMetricModelImpl.getOriginalJiraComponentId(),
						jiraMetricModelImpl.getOriginalJiraStatusId(),
						jiraMetricModelImpl.getOriginalDay(),
						jiraMetricModelImpl.getOriginalMonth(),
						jiraMetricModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_C_S_D_M_Y,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_C_S_D_M_Y,
					args);

				args = new Object[] {
						jiraMetricModelImpl.getJiraProjectId(),
						jiraMetricModelImpl.getJiraComponentId(),
						jiraMetricModelImpl.getJiraStatusId(),
						jiraMetricModelImpl.getDay(),
						jiraMetricModelImpl.getMonth(),
						jiraMetricModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_C_S_D_M_Y,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_C_S_D_M_Y,
					args);
			}
		}

		EntityCacheUtil.putResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
			JiraMetricImpl.class, jiraMetric.getPrimaryKey(), jiraMetric);

		return jiraMetric;
	}

	protected JiraMetric toUnwrappedModel(JiraMetric jiraMetric) {
		if (jiraMetric instanceof JiraMetricImpl) {
			return jiraMetric;
		}

		JiraMetricImpl jiraMetricImpl = new JiraMetricImpl();

		jiraMetricImpl.setNew(jiraMetric.isNew());
		jiraMetricImpl.setPrimaryKey(jiraMetric.getPrimaryKey());

		jiraMetricImpl.setJiraMetricId(jiraMetric.getJiraMetricId());
		jiraMetricImpl.setUserId(jiraMetric.getUserId());
		jiraMetricImpl.setUserName(jiraMetric.getUserName());
		jiraMetricImpl.setCreateDate(jiraMetric.getCreateDate());
		jiraMetricImpl.setModifiedDate(jiraMetric.getModifiedDate());
		jiraMetricImpl.setJiraProjectId(jiraMetric.getJiraProjectId());
		jiraMetricImpl.setJiraComponentId(jiraMetric.getJiraComponentId());
		jiraMetricImpl.setJiraStatusId(jiraMetric.getJiraStatusId());
		jiraMetricImpl.setPriority(jiraMetric.getPriority());
		jiraMetricImpl.setDay(jiraMetric.getDay());
		jiraMetricImpl.setMonth(jiraMetric.getMonth());
		jiraMetricImpl.setYear(jiraMetric.getYear());
		jiraMetricImpl.setTotal(jiraMetric.getTotal());

		return jiraMetricImpl;
	}

	/**
	 * Returns the jira metric with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira metric
	 * @return the jira metric
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJiraMetricException, SystemException {
		JiraMetric jiraMetric = fetchByPrimaryKey(primaryKey);

		if (jiraMetric == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJiraMetricException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jiraMetric;
	}

	/**
	 * Returns the jira metric with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraMetricException} if it could not be found.
	 *
	 * @param jiraMetricId the primary key of the jira metric
	 * @return the jira metric
	 * @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric findByPrimaryKey(long jiraMetricId)
		throws NoSuchJiraMetricException, SystemException {
		return findByPrimaryKey((Serializable)jiraMetricId);
	}

	/**
	 * Returns the jira metric with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira metric
	 * @return the jira metric, or <code>null</code> if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JiraMetric jiraMetric = (JiraMetric)EntityCacheUtil.getResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
				JiraMetricImpl.class, primaryKey);

		if (jiraMetric == _nullJiraMetric) {
			return null;
		}

		if (jiraMetric == null) {
			Session session = null;

			try {
				session = openSession();

				jiraMetric = (JiraMetric)session.get(JiraMetricImpl.class,
						primaryKey);

				if (jiraMetric != null) {
					cacheResult(jiraMetric);
				}
				else {
					EntityCacheUtil.putResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
						JiraMetricImpl.class, primaryKey, _nullJiraMetric);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JiraMetricModelImpl.ENTITY_CACHE_ENABLED,
					JiraMetricImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jiraMetric;
	}

	/**
	 * Returns the jira metric with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jiraMetricId the primary key of the jira metric
	 * @return the jira metric, or <code>null</code> if a jira metric with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraMetric fetchByPrimaryKey(long jiraMetricId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jiraMetricId);
	}

	/**
	 * Returns all the jira metrics.
	 *
	 * @return the jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraMetric> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira metrics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira metrics
	 * @param end the upper bound of the range of jira metrics (not inclusive)
	 * @return the range of jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraMetric> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira metrics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira metrics
	 * @param end the upper bound of the range of jira metrics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jira metrics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraMetric> findAll(int start, int end,
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

		List<JiraMetric> list = (List<JiraMetric>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JIRAMETRIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JIRAMETRIC;

				if (pagination) {
					sql = sql.concat(JiraMetricModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JiraMetric>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraMetric>(list);
				}
				else {
					list = (List<JiraMetric>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the jira metrics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JiraMetric jiraMetric : findAll()) {
			remove(jiraMetric);
		}
	}

	/**
	 * Returns the number of jira metrics.
	 *
	 * @return the number of jira metrics
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

				Query q = session.createQuery(_SQL_COUNT_JIRAMETRIC);

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
	 * Initializes the jira metric persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.jira.metrics.model.JiraMetric")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JiraMetric>> listenersList = new ArrayList<ModelListener<JiraMetric>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JiraMetric>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JiraMetricImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JIRAMETRIC = "SELECT jiraMetric FROM JiraMetric jiraMetric";
	private static final String _SQL_SELECT_JIRAMETRIC_WHERE = "SELECT jiraMetric FROM JiraMetric jiraMetric WHERE ";
	private static final String _SQL_COUNT_JIRAMETRIC = "SELECT COUNT(jiraMetric) FROM JiraMetric jiraMetric";
	private static final String _SQL_COUNT_JIRAMETRIC_WHERE = "SELECT COUNT(jiraMetric) FROM JiraMetric jiraMetric WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraMetric.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraMetric exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraMetric exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JiraMetricPersistenceImpl.class);
	private static JiraMetric _nullJiraMetric = new JiraMetricImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JiraMetric> toCacheModel() {
				return _nullJiraMetricCacheModel;
			}
		};

	private static CacheModel<JiraMetric> _nullJiraMetricCacheModel = new CacheModel<JiraMetric>() {
			@Override
			public JiraMetric toEntityModel() {
				return _nullJiraMetric;
			}
		};
}