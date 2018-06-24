package com.example.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.util.MessageProp;
import com.common.util.Status;
import com.example.mapper.SampleMapper;
import com.example.service.SampleService;
import com.example.vo.DepChartVo;
import com.example.vo.DepListVo;
import com.example.vo.EmpListVo;
import com.example.vo.EmpSaveVo;
import com.example.vo.JobChartVo;
import com.example.vo.JobListVo;

@Service
@MapperScan("com.example.mapper")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;

	@Override
	@Transactional(readOnly=true)
	public List<EmpListVo> getEmpList(Long departmentId) {
		return sampleMapper.getEmpList(departmentId);
	}

	@Override
	public String setEmp(List<EmpSaveVo> vos) {

		try {

			for (EmpSaveVo vo : vos) {

				if (vo.get_status() == Status.Delete.getStatus()) {
					sampleMapper.delEmp(vo.getEmployeeId());

				} else if (vo.get_status() == Status.New.getStatus()) {
					sampleMapper.insEmp(vo);

				} else if (vo.get_status() == Status.Modified.getStatus()) {
					sampleMapper.setEmp(vo);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return MessageProp.ERR_SAVE.getMsg();
		}

		return MessageProp.INFO_SAVE.getMsg();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepListVo> getDepList() {
		return sampleMapper.getDepList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<JobListVo> getJobList() {
		return sampleMapper.getJobList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepChartVo> getDepChart() {
		return sampleMapper.getDepChart();
	}

	@Override
	@Transactional(readOnly=true)
	public List<JobChartVo> getJobChart() {
		return sampleMapper.getJobChart();
	}

}
