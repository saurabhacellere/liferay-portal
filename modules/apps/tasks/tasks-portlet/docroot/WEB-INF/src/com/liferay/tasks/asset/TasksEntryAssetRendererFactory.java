/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.tasks.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.tasks.model.TasksEntry;
import com.liferay.tasks.service.TasksEntryLocalServiceUtil;
import com.liferay.tasks.service.permission.TasksEntryPermission;

/**
 * @author Matthew Kong
 */
public class TasksEntryAssetRendererFactory
	extends BaseAssetRendererFactory<TasksEntry> {

	public static final String CLASS_NAME = TasksEntry.class.getName();

	public static final String TYPE = "tasks";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException {

		TasksEntry tasksEntry = TasksEntryLocalServiceUtil.getTasksEntry(
			classPK);

		return new TasksEntryAssetRenderer(tasksEntry);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getIconCssClass() {
		return "icon-tasks";
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return TasksEntryPermission.contains(
			permissionChecker, classPK, actionId);
	}

}