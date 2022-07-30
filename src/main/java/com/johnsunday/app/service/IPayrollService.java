package com.johnsunday.app.service;

import java.util.List;

import com.johnsunday.app.entity.Expense;
import com.johnsunday.app.entity.Payroll;

public interface IPayrollService extends IBaseService<Payroll,Integer> {

	public List<Payroll> findPayrollByEmployeeId(Integer id) throws Exception;
}
