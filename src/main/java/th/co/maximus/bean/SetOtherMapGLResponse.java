package th.co.maximus.bean;

import java.util.List;

public class SetOtherMapGLResponse {
	private List<MapGLBean> mapGLBean;
	private List<MasterDataBean> masterSegments;
	private List<MasterDataBean> masterProducts;

	public List<MapGLBean> getMapGLBean() {
		return mapGLBean;
	}

	public void setMapGLBean(List<MapGLBean> mapGLBean) {
		this.mapGLBean = mapGLBean;
	}

	public List<MasterDataBean> getMasterSegments() {
		return masterSegments;
	}

	public void setMasterSegments(List<MasterDataBean> masterSegments) {
		this.masterSegments = masterSegments;
	}

	public List<MasterDataBean> getMasterProducts() {
		return masterProducts;
	}

	public void setMasterProducts(List<MasterDataBean> masterProducts) {
		this.masterProducts = masterProducts;
	}

}
