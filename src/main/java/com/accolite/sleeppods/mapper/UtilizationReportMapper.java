package com.accolite.sleeppods.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.sleeppods.model.UtilizationReport;

public class UtilizationReportMapper implements RowMapper<UtilizationReport> {

	@Override
	public UtilizationReport mapRow(ResultSet rs, int rowNum) throws SQLException {
		UtilizationReport report = new UtilizationReport();
		report.setCount(rs.getInt("COUNT"));
		report.setDayy(rs.getInt("DAYY"));
		return report;
	}


}
