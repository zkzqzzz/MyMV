/**
 * Copyright (C) 2013 Aurélien Chabot <aurelien@chabot.fr>
 * 
 * This file is part of DroidUPNP.
 * 
 * DroidUPNP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DroidUPNP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with DroidUPNP.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.demo.zk.mymv.controller.cling;

import android.content.Context;

import com.demo.zk.mymv.MyApplication;
import com.demo.zk.mymv.controller.upnp.IUpnpServiceController;
import com.demo.zk.mymv.model.cling.RendererState;
import com.demo.zk.mymv.model.upnp.ARendererState;
import com.demo.zk.mymv.model.upnp.IFactory;
import com.demo.zk.mymv.model.upnp.IRendererCommand;
import com.demo.zk.mymv.model.upnp.IRendererState;

import org.fourthline.cling.android.AndroidUpnpService;
import org.fourthline.cling.controlpoint.ControlPoint;

public class Factory implements IFactory {


	@Override
	public IRendererCommand createRendererCommand(IRendererState rs)
	{
		AndroidUpnpService aus = ((ServiceListener) MyApplication.upnpServiceController.getServiceListener()).getUpnpService();
		ControlPoint cp = null;
		if (aus != null)
			cp = aus.getControlPoint();
		if (cp != null)
			return new RendererCommand(cp, (RendererState) rs);

		return null;
	}

	@Override
	public IUpnpServiceController createUpnpServiceController(Context ctx)
	{
		return new ServiceController(ctx);
	}

	@Override
	public ARendererState createRendererState()
	{
		return new RendererState();
	}
}
