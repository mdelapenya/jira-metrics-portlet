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

import com.liferay.jira.metrics.NoSuchJiraComponentException;
import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.impl.JiraComponentImpl;
import com.liferay.jira.metrics.model.impl.JiraComponentModelImpl;

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
 * The persistence implementation for the jira component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraComponentPersistence
 * @see JiraComponentUtil
 * @generated
 */
public class JiraComponentPersistenceImpl extends BasePersistenceImpl<JiraComponent>
	implements JiraComponentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JiraComponentUtil} to access the jira component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JiraComponentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED,
			JiraComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED,
			JiraComponentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_JIRACOMPONENT = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED,
			JiraComponentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByJiraComponent",
			new String[] { String.class.getName(), Long.class.getName() },
			JiraComponentModelImpl.NAME_COLUMN_BITMASK |
			JiraComponentModelImpl.JIRAPROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JIRACOMPONENT = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJiraComponent",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the jira component where name = &#63; and jiraProjectId = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	 *
	 * @param name the name
	 * @param jiraProjectId the jira project ID
	 * @return the matching jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent findByJiraComponent(String name, long jiraProjectId)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = fetchByJiraComponent(name, jiraProjectId);

		if (jiraComponent == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", jiraProjectId=");
			msg.append(jiraProjectId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraComponentException(msg.toString());
		}

		return jiraComponent;
	}

	/**
	 * Returns the jira component where name = &#63; and jiraProjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param jiraProjectId the jira project ID
	 * @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByJiraComponent(String name, long jiraProjectId)
		throws SystemException {
		return fetchByJiraComponent(name, jiraProjectId, true);
	}

	/**
	 * Returns the jira component where name = &#63; and jiraProjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param jiraProjectId the jira project ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByJiraComponent(String name, long jiraProjectId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, jiraProjectId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
					finderArgs, this);
		}

		if (result instanceof JiraComponent) {
			JiraComponent jiraComponent = (JiraComponent)result;

			if (!Validator.equals(name, jiraComponent.getName()) ||
					(jiraProjectId != jiraComponent.getJiraProjectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_JIRACOMPONENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_JIRACOMPONENT_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JIRACOMPONENT_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_JIRACOMPONENT_NAME_2);
			}

			query.append(_FINDER_COLUMN_JIRACOMPONENT_JIRAPROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(jiraProjectId);

				List<JiraComponent> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"JiraComponentPersistenceImpl.fetchByJiraComponent(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					JiraComponent jiraComponent = list.get(0);

					result = jiraComponent;

					cacheResult(jiraComponent);

					if ((jiraComponent.getName() == null) ||
							!jiraComponent.getName().equals(name) ||
							(jiraComponent.getJiraProjectId() != jiraProjectId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
							finderArgs, jiraComponent);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
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
			return (JiraComponent)result;
		}
	}

	/**
	 * Removes the jira component where name = &#63; and jiraProjectId = &#63; from the database.
	 *
	 * @param name the name
	 * @param jiraProjectId the jira project ID
	 * @return the jira component that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent removeByJiraComponent(String name, long jiraProjectId)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = findByJiraComponent(name, jiraProjectId);

		return remove(jiraComponent);
	}

	/**
	 * Returns the number of jira components where name = &#63; and jiraProjectId = &#63;.
	 *
	 * @param name the name
	 * @param jiraProjectId the jira project ID
	 * @return the number of matching jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJiraComponent(String name, long jiraProjectId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JIRACOMPONENT;

		Object[] finderArgs = new Object[] { name, jiraProjectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JIRACOMPONENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_JIRACOMPONENT_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JIRACOMPONENT_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_JIRACOMPONENT_NAME_2);
			}

			query.append(_FINDER_COLUMN_JIRACOMPONENT_JIRAPROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(jiraProjectId);

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

	private static final String _FINDER_COLUMN_JIRACOMPONENT_NAME_1 = "jiraComponent.name IS NULL AND ";
	private static final String _FINDER_COLUMN_JIRACOMPONENT_NAME_2 = "jiraComponent.name = ? AND ";
	private static final String _FINDER_COLUMN_JIRACOMPONENT_NAME_3 = "(jiraComponent.name IS NULL OR jiraComponent.name = '') AND ";
	private static final String _FINDER_COLUMN_JIRACOMPONENT_JIRAPROJECTID_2 = "jiraComponent.jiraProjectId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_URI = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED,
			JiraComponentImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUri",
			new String[] { String.class.getName() },
			JiraComponentModelImpl.URI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_URI = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUri",
			new String[] { String.class.getName() });

	/**
	 * Returns the jira component where uri = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	 *
	 * @param uri the uri
	 * @return the matching jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent findByUri(String uri)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = fetchByUri(uri);

		if (jiraComponent == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uri=");
			msg.append(uri);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJiraComponentException(msg.toString());
		}

		return jiraComponent;
	}

	/**
	 * Returns the jira component where uri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uri the uri
	 * @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByUri(String uri) throws SystemException {
		return fetchByUri(uri, true);
	}

	/**
	 * Returns the jira component where uri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uri the uri
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByUri(String uri, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { uri };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_URI,
					finderArgs, this);
		}

		if (result instanceof JiraComponent) {
			JiraComponent jiraComponent = (JiraComponent)result;

			if (!Validator.equals(uri, jiraComponent.getUri())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JIRACOMPONENT_WHERE);

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

				List<JiraComponent> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
						finderArgs, list);
				}
				else {
					JiraComponent jiraComponent = list.get(0);

					result = jiraComponent;

					cacheResult(jiraComponent);

					if ((jiraComponent.getUri() == null) ||
							!jiraComponent.getUri().equals(uri)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
							finderArgs, jiraComponent);
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
			return (JiraComponent)result;
		}
	}

	/**
	 * Removes the jira component where uri = &#63; from the database.
	 *
	 * @param uri the uri
	 * @return the jira component that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent removeByUri(String uri)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = findByUri(uri);

		return remove(jiraComponent);
	}

	/**
	 * Returns the number of jira components where uri = &#63;.
	 *
	 * @param uri the uri
	 * @return the number of matching jira components
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

			query.append(_SQL_COUNT_JIRACOMPONENT_WHERE);

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

	private static final String _FINDER_COLUMN_URI_URI_1 = "jiraComponent.uri IS NULL";
	private static final String _FINDER_COLUMN_URI_URI_2 = "jiraComponent.uri = ?";
	private static final String _FINDER_COLUMN_URI_URI_3 = "(jiraComponent.uri IS NULL OR jiraComponent.uri = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JIRAPROJECTID =
		new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED,
			JiraComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByJiraProjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JIRAPROJECTID =
		new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED,
			JiraComponentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByJiraProjectId", new String[] { Long.class.getName() },
			JiraComponentModelImpl.JIRAPROJECTID_COLUMN_BITMASK |
			JiraComponentModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JIRAPROJECTID = new FinderPath(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJiraProjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the jira components where jiraProjectId = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @return the matching jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraComponent> findByJiraProjectId(long jiraProjectId)
		throws SystemException {
		return findByJiraProjectId(jiraProjectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira components where jiraProjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jiraProjectId the jira project ID
	 * @param start the lower bound of the range of jira components
	 * @param end the upper bound of the range of jira components (not inclusive)
	 * @return the range of matching jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraComponent> findByJiraProjectId(long jiraProjectId,
		int start, int end) throws SystemException {
		return findByJiraProjectId(jiraProjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira components where jiraProjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jiraProjectId the jira project ID
	 * @param start the lower bound of the range of jira components
	 * @param end the upper bound of the range of jira components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraComponent> findByJiraProjectId(long jiraProjectId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JIRAPROJECTID;
			finderArgs = new Object[] { jiraProjectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JIRAPROJECTID;
			finderArgs = new Object[] {
					jiraProjectId,
					
					start, end, orderByComparator
				};
		}

		List<JiraComponent> list = (List<JiraComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JiraComponent jiraComponent : list) {
				if ((jiraProjectId != jiraComponent.getJiraProjectId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_JIRACOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_JIRAPROJECTID_JIRAPROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JiraComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jiraProjectId);

				if (!pagination) {
					list = (List<JiraComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraComponent>(list);
				}
				else {
					list = (List<JiraComponent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first jira component in the ordered set where jiraProjectId = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent findByJiraProjectId_First(long jiraProjectId,
		OrderByComparator orderByComparator)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = fetchByJiraProjectId_First(jiraProjectId,
				orderByComparator);

		if (jiraComponent != null) {
			return jiraComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jiraProjectId=");
		msg.append(jiraProjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJiraComponentException(msg.toString());
	}

	/**
	 * Returns the first jira component in the ordered set where jiraProjectId = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jira component, or <code>null</code> if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByJiraProjectId_First(long jiraProjectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<JiraComponent> list = findByJiraProjectId(jiraProjectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last jira component in the ordered set where jiraProjectId = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent findByJiraProjectId_Last(long jiraProjectId,
		OrderByComparator orderByComparator)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = fetchByJiraProjectId_Last(jiraProjectId,
				orderByComparator);

		if (jiraComponent != null) {
			return jiraComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jiraProjectId=");
		msg.append(jiraProjectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJiraComponentException(msg.toString());
	}

	/**
	 * Returns the last jira component in the ordered set where jiraProjectId = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jira component, or <code>null</code> if a matching jira component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByJiraProjectId_Last(long jiraProjectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByJiraProjectId(jiraProjectId);

		if (count == 0) {
			return null;
		}

		List<JiraComponent> list = findByJiraProjectId(jiraProjectId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the jira components before and after the current jira component in the ordered set where jiraProjectId = &#63;.
	 *
	 * @param jiraComponentId the primary key of the current jira component
	 * @param jiraProjectId the jira project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent[] findByJiraProjectId_PrevAndNext(
		long jiraComponentId, long jiraProjectId,
		OrderByComparator orderByComparator)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = findByPrimaryKey(jiraComponentId);

		Session session = null;

		try {
			session = openSession();

			JiraComponent[] array = new JiraComponentImpl[3];

			array[0] = getByJiraProjectId_PrevAndNext(session, jiraComponent,
					jiraProjectId, orderByComparator, true);

			array[1] = jiraComponent;

			array[2] = getByJiraProjectId_PrevAndNext(session, jiraComponent,
					jiraProjectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JiraComponent getByJiraProjectId_PrevAndNext(Session session,
		JiraComponent jiraComponent, long jiraProjectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JIRACOMPONENT_WHERE);

		query.append(_FINDER_COLUMN_JIRAPROJECTID_JIRAPROJECTID_2);

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
			query.append(JiraComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jiraProjectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jiraComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JiraComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jira components where jiraProjectId = &#63; from the database.
	 *
	 * @param jiraProjectId the jira project ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJiraProjectId(long jiraProjectId)
		throws SystemException {
		for (JiraComponent jiraComponent : findByJiraProjectId(jiraProjectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jiraComponent);
		}
	}

	/**
	 * Returns the number of jira components where jiraProjectId = &#63;.
	 *
	 * @param jiraProjectId the jira project ID
	 * @return the number of matching jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJiraProjectId(long jiraProjectId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JIRAPROJECTID;

		Object[] finderArgs = new Object[] { jiraProjectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JIRACOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_JIRAPROJECTID_JIRAPROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jiraProjectId);

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

	private static final String _FINDER_COLUMN_JIRAPROJECTID_JIRAPROJECTID_2 = "jiraComponent.jiraProjectId = ?";

	public JiraComponentPersistenceImpl() {
		setModelClass(JiraComponent.class);
	}

	/**
	 * Caches the jira component in the entity cache if it is enabled.
	 *
	 * @param jiraComponent the jira component
	 */
	@Override
	public void cacheResult(JiraComponent jiraComponent) {
		EntityCacheUtil.putResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentImpl.class, jiraComponent.getPrimaryKey(),
			jiraComponent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
			new Object[] {
				jiraComponent.getName(), jiraComponent.getJiraProjectId()
			}, jiraComponent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI,
			new Object[] { jiraComponent.getUri() }, jiraComponent);

		jiraComponent.resetOriginalValues();
	}

	/**
	 * Caches the jira components in the entity cache if it is enabled.
	 *
	 * @param jiraComponents the jira components
	 */
	@Override
	public void cacheResult(List<JiraComponent> jiraComponents) {
		for (JiraComponent jiraComponent : jiraComponents) {
			if (EntityCacheUtil.getResult(
						JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
						JiraComponentImpl.class, jiraComponent.getPrimaryKey()) == null) {
				cacheResult(jiraComponent);
			}
			else {
				jiraComponent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jira components.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JiraComponentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JiraComponentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jira component.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JiraComponent jiraComponent) {
		EntityCacheUtil.removeResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentImpl.class, jiraComponent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(jiraComponent);
	}

	@Override
	public void clearCache(List<JiraComponent> jiraComponents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JiraComponent jiraComponent : jiraComponents) {
			EntityCacheUtil.removeResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
				JiraComponentImpl.class, jiraComponent.getPrimaryKey());

			clearUniqueFindersCache(jiraComponent);
		}
	}

	protected void cacheUniqueFindersCache(JiraComponent jiraComponent) {
		if (jiraComponent.isNew()) {
			Object[] args = new Object[] {
					jiraComponent.getName(), jiraComponent.getJiraProjectId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JIRACOMPONENT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT, args,
				jiraComponent);

			args = new Object[] { jiraComponent.getUri() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URI, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI, args,
				jiraComponent);
		}
		else {
			JiraComponentModelImpl jiraComponentModelImpl = (JiraComponentModelImpl)jiraComponent;

			if ((jiraComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JIRACOMPONENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jiraComponent.getName(),
						jiraComponent.getJiraProjectId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JIRACOMPONENT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
					args, jiraComponent);
			}

			if ((jiraComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_URI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jiraComponent.getUri() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URI, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URI, args,
					jiraComponent);
			}
		}
	}

	protected void clearUniqueFindersCache(JiraComponent jiraComponent) {
		JiraComponentModelImpl jiraComponentModelImpl = (JiraComponentModelImpl)jiraComponent;

		Object[] args = new Object[] {
				jiraComponent.getName(), jiraComponent.getJiraProjectId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JIRACOMPONENT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT, args);

		if ((jiraComponentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_JIRACOMPONENT.getColumnBitmask()) != 0) {
			args = new Object[] {
					jiraComponentModelImpl.getOriginalName(),
					jiraComponentModelImpl.getOriginalJiraProjectId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JIRACOMPONENT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JIRACOMPONENT,
				args);
		}

		args = new Object[] { jiraComponent.getUri() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URI, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI, args);

		if ((jiraComponentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_URI.getColumnBitmask()) != 0) {
			args = new Object[] { jiraComponentModelImpl.getOriginalUri() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URI, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URI, args);
		}
	}

	/**
	 * Creates a new jira component with the primary key. Does not add the jira component to the database.
	 *
	 * @param jiraComponentId the primary key for the new jira component
	 * @return the new jira component
	 */
	@Override
	public JiraComponent create(long jiraComponentId) {
		JiraComponent jiraComponent = new JiraComponentImpl();

		jiraComponent.setNew(true);
		jiraComponent.setPrimaryKey(jiraComponentId);

		return jiraComponent;
	}

	/**
	 * Removes the jira component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jiraComponentId the primary key of the jira component
	 * @return the jira component that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent remove(long jiraComponentId)
		throws NoSuchJiraComponentException, SystemException {
		return remove((Serializable)jiraComponentId);
	}

	/**
	 * Removes the jira component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jira component
	 * @return the jira component that was removed
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent remove(Serializable primaryKey)
		throws NoSuchJiraComponentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JiraComponent jiraComponent = (JiraComponent)session.get(JiraComponentImpl.class,
					primaryKey);

			if (jiraComponent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJiraComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jiraComponent);
		}
		catch (NoSuchJiraComponentException nsee) {
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
	protected JiraComponent removeImpl(JiraComponent jiraComponent)
		throws SystemException {
		jiraComponent = toUnwrappedModel(jiraComponent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jiraComponent)) {
				jiraComponent = (JiraComponent)session.get(JiraComponentImpl.class,
						jiraComponent.getPrimaryKeyObj());
			}

			if (jiraComponent != null) {
				session.delete(jiraComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jiraComponent != null) {
			clearCache(jiraComponent);
		}

		return jiraComponent;
	}

	@Override
	public JiraComponent updateImpl(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent)
		throws SystemException {
		jiraComponent = toUnwrappedModel(jiraComponent);

		boolean isNew = jiraComponent.isNew();

		JiraComponentModelImpl jiraComponentModelImpl = (JiraComponentModelImpl)jiraComponent;

		Session session = null;

		try {
			session = openSession();

			if (jiraComponent.isNew()) {
				session.save(jiraComponent);

				jiraComponent.setNew(false);
			}
			else {
				session.merge(jiraComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JiraComponentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jiraComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JIRAPROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jiraComponentModelImpl.getOriginalJiraProjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JIRAPROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JIRAPROJECTID,
					args);

				args = new Object[] { jiraComponentModelImpl.getJiraProjectId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JIRAPROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JIRAPROJECTID,
					args);
			}
		}

		EntityCacheUtil.putResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
			JiraComponentImpl.class, jiraComponent.getPrimaryKey(),
			jiraComponent);

		clearUniqueFindersCache(jiraComponent);
		cacheUniqueFindersCache(jiraComponent);

		return jiraComponent;
	}

	protected JiraComponent toUnwrappedModel(JiraComponent jiraComponent) {
		if (jiraComponent instanceof JiraComponentImpl) {
			return jiraComponent;
		}

		JiraComponentImpl jiraComponentImpl = new JiraComponentImpl();

		jiraComponentImpl.setNew(jiraComponent.isNew());
		jiraComponentImpl.setPrimaryKey(jiraComponent.getPrimaryKey());

		jiraComponentImpl.setJiraComponentId(jiraComponent.getJiraComponentId());
		jiraComponentImpl.setCreateDate(jiraComponent.getCreateDate());
		jiraComponentImpl.setModifiedDate(jiraComponent.getModifiedDate());
		jiraComponentImpl.setUri(jiraComponent.getUri());
		jiraComponentImpl.setJiraProjectId(jiraComponent.getJiraProjectId());
		jiraComponentImpl.setName(jiraComponent.getName());
		jiraComponentImpl.setDisabled(jiraComponent.isDisabled());

		return jiraComponentImpl;
	}

	/**
	 * Returns the jira component with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira component
	 * @return the jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJiraComponentException, SystemException {
		JiraComponent jiraComponent = fetchByPrimaryKey(primaryKey);

		if (jiraComponent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJiraComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jiraComponent;
	}

	/**
	 * Returns the jira component with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	 *
	 * @param jiraComponentId the primary key of the jira component
	 * @return the jira component
	 * @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent findByPrimaryKey(long jiraComponentId)
		throws NoSuchJiraComponentException, SystemException {
		return findByPrimaryKey((Serializable)jiraComponentId);
	}

	/**
	 * Returns the jira component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jira component
	 * @return the jira component, or <code>null</code> if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JiraComponent jiraComponent = (JiraComponent)EntityCacheUtil.getResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
				JiraComponentImpl.class, primaryKey);

		if (jiraComponent == _nullJiraComponent) {
			return null;
		}

		if (jiraComponent == null) {
			Session session = null;

			try {
				session = openSession();

				jiraComponent = (JiraComponent)session.get(JiraComponentImpl.class,
						primaryKey);

				if (jiraComponent != null) {
					cacheResult(jiraComponent);
				}
				else {
					EntityCacheUtil.putResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
						JiraComponentImpl.class, primaryKey, _nullJiraComponent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JiraComponentModelImpl.ENTITY_CACHE_ENABLED,
					JiraComponentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jiraComponent;
	}

	/**
	 * Returns the jira component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jiraComponentId the primary key of the jira component
	 * @return the jira component, or <code>null</code> if a jira component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JiraComponent fetchByPrimaryKey(long jiraComponentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jiraComponentId);
	}

	/**
	 * Returns all the jira components.
	 *
	 * @return the jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraComponent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jira components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira components
	 * @param end the upper bound of the range of jira components (not inclusive)
	 * @return the range of jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraComponent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jira components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jira components
	 * @param end the upper bound of the range of jira components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jira components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JiraComponent> findAll(int start, int end,
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

		List<JiraComponent> list = (List<JiraComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JIRACOMPONENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JIRACOMPONENT;

				if (pagination) {
					sql = sql.concat(JiraComponentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JiraComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JiraComponent>(list);
				}
				else {
					list = (List<JiraComponent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the jira components from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JiraComponent jiraComponent : findAll()) {
			remove(jiraComponent);
		}
	}

	/**
	 * Returns the number of jira components.
	 *
	 * @return the number of jira components
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

				Query q = session.createQuery(_SQL_COUNT_JIRACOMPONENT);

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
	 * Initializes the jira component persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.jira.metrics.model.JiraComponent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JiraComponent>> listenersList = new ArrayList<ModelListener<JiraComponent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JiraComponent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JiraComponentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JIRACOMPONENT = "SELECT jiraComponent FROM JiraComponent jiraComponent";
	private static final String _SQL_SELECT_JIRACOMPONENT_WHERE = "SELECT jiraComponent FROM JiraComponent jiraComponent WHERE ";
	private static final String _SQL_COUNT_JIRACOMPONENT = "SELECT COUNT(jiraComponent) FROM JiraComponent jiraComponent";
	private static final String _SQL_COUNT_JIRACOMPONENT_WHERE = "SELECT COUNT(jiraComponent) FROM JiraComponent jiraComponent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraComponent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraComponent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraComponent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JiraComponentPersistenceImpl.class);
	private static JiraComponent _nullJiraComponent = new JiraComponentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JiraComponent> toCacheModel() {
				return _nullJiraComponentCacheModel;
			}
		};

	private static CacheModel<JiraComponent> _nullJiraComponentCacheModel = new CacheModel<JiraComponent>() {
			@Override
			public JiraComponent toEntityModel() {
				return _nullJiraComponent;
			}
		};
}