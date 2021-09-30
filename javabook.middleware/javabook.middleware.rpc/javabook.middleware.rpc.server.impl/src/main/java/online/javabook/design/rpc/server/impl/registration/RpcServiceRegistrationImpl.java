/**
 *
 */
package online.javabook.design.rpc.server.impl.registration;

import online.javabook.design.rpc.server.api.registration.IRpcServiceRegistration;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcServiceRegistrationImpl implements IRpcServiceRegistration, Serializable {

	/**
	 * DUMMY
	 */
	public static IRpcServiceRegistration NOTFOUND = new RpcServiceRegistrationImpl("NOTFOUND");

	/**
	 *
	 */
	private static final long serialVersionUID = 5561500967798786959L;

	// ====================================================================================================
	// service
	// ====================================================================================================

	/**
	 * service serviceName.
	 */
	private String serviceName;

	/**
	 * service object for this registration.
	 */
	private Object serviceObject;

	/**
	 * service classes
	 */
	private String[] interfaceNames;

	// ----------------------------------------------------------------------------------------------------

	/**
	 * service host.
	 */
	private String host;

	/**
	 * service port.
	 */
	private int port;

	// ----------------------------------------------------------------------------------------------------

	/**
	 * service application.
	 */
	private String application;

	/**
	 * service ranking.
	 */
	private int ranking;

	/**
	 * service version.
	 */
	private String version;

	/**
	 * service vendor.
	 */
	private String vendor;

	/**
	 * service description.
	 */
	private String description;

	// ====================================================================================================
	// ServiceRegistrationImpl
	// ====================================================================================================

	/**
	 * @param serviceName
	 */
	public RpcServiceRegistrationImpl(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 *
	 */
	public RpcServiceRegistrationImpl() {

	}

	/**
	 * @param service
	 */
	public <S> RpcServiceRegistrationImpl(S service) {
		this.serviceObject   = service;
	}

	// ----------------------------------------------------------------------------------------------------

	@Override
	public String getServiceName() {
		return serviceName;
	}

	@Override
	public void setServiceName(String name) {
		this.serviceName = name;
	}

	@Override
	public Object getServiceObject() {
		return serviceObject;
	}

	@Override
	public void setServiceObject(Object service) {
		this.serviceObject = service;
	}

	@Override
	public String[] getInterfaceNames() {
		return interfaceNames;
	}

	@Override
	public void setInterfaceNames(String[] classes) {
		this.interfaceNames = classes;
	}

	// ----------------------------------------------------------------------------------------------------

	@Override
	public String getRpcProviderHost() {
		return host;
	}

	@Override
	public void setRpcProviderHost(String host) {
		this.host = host;
	}

	@Override
	public int getRpcProviderPort() {
		return port;
	}

	@Override
	public void setRpcProviderPort(int port) {
		this.port = port;
	}

	// ====================================================================================================
	// get
	// ====================================================================================================

	@Override
	public String getApplication() {
		return application;
	}

	@Override
	public void setApplication(String application) {
		this.application = application;
	}

	/**
	 * @return the serviceRanking
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * @param serviceRanking the serviceRanking to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	// ====================================================================================================
	// Object
	// ====================================================================================================

	@Override
	public boolean equals(Object obj) {

		if( !(obj instanceof IRpcServiceRegistration) ) return false;

		if( obj == this ) return true;

		IRpcServiceRegistration other = (IRpcServiceRegistration) obj;
		if(!this.application.equals(other.getApplication()))
			return false;

		else if(this.vendor != other.getVendor())
			return false;

		else if(this.serviceName != other.getServiceName())
			return false;

		else if(!this.host.equals(other.getRpcProviderHost()))
			return false;

		else if(this.port != other.getRpcProviderPort())
			return false;

		else if(this.version != other.getVersion())
			return false;

		else if(this.ranking != other.getRanking())
			return false;

		else if(!this.description.equals(other.getDescription()))
			return false;

		return true;
	}

	/**
	 * Return a String representation of this object.
	 *
	 * @return String representation of this object.
	 */
	public String toString() {

		if(interfaceNames==null) return "{}";
		int size = interfaceNames.length;
		StringBuffer sb = new StringBuffer(50 * size);

		sb.append("{\n");

		sb.append("application:"+this.application).append("\n");
		sb.append("vendor:"+this.vendor).append("\n");
		sb.append("serviceName:"+this.serviceName).append("\n");
		sb.append("host:"+this.host).append("\n");
		sb.append("port:"+this.port).append("\n");
		sb.append("version:"+this.version).append("\n");
		sb.append("ranking:"+this.ranking).append("\n");
		sb.append("description:"+this.description).append("\n");

		sb.append("}="); //$NON-NLS-1$

		return sb.toString();
	}

}
