package com.johnsunday.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.johnsunday.app.dao.IExpenseDao;
import com.johnsunday.app.entity.Expense;

@Service
public class ExpenseServiceImpl extends BaseServiceImpl<Expense,Integer> 
								implements IExpenseService {

	@Autowired
	private IExpenseDao expenseDao;

	@Override
	public List<Expense> findExpenseByEmployeeId(Integer employeeId) throws Exception {
		try {
			return expenseDao.findAllExpenseByIdEmployee(employeeId);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}	
}