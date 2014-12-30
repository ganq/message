package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApi;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiLocator;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoapStub;

public class DataObjectFactory {
	
	private static DataObjectBean mobsetBean = null;
	private static MobsetApiSoap mobsetApiSub = null;
	private static MobsetApi mobsetApi = null;
	
	private DataObjectFactory() {}
	
	public static DataObjectBean getInstance(){
		if(mobsetBean==null)
			mobsetBean=new DataObjectBean();
		      return mobsetBean;
	}
	
	public static MobsetApiSoap getMobsetApi(){
		if(mobsetApi==null)
			try {
				mobsetApi=new MobsetApiLocator();
				mobsetApiSub=(MobsetApiSoapStub)mobsetApi.getMobsetApiSoap();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      return mobsetApiSub;
	}
}
