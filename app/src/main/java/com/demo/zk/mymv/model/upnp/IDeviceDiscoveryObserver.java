package com.demo.zk.mymv.model.upnp;

public interface IDeviceDiscoveryObserver {

	public void addedDevice(IUpnpDevice device);

	public void removedDevice(IUpnpDevice device);
}
