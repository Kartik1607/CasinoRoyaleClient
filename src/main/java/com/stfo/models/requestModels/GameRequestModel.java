package com.stfo.models.requestModels;

import org.springframework.stereotype.Component;

import com.stfo.models.CasinoTableModel;

@Component
public class GameRequestModel {

	private Long userId;
	private CasinoTableModel casinoTable;

	public GameRequestModel() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public CasinoTableModel getCasinoTable() {
		return casinoTable;
	}

	public void setCasinoTable(CasinoTableModel casinoTable) {
		this.casinoTable = casinoTable;
	}

}
