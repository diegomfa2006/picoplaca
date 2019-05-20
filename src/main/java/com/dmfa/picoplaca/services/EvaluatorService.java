package com.dmfa.picoplaca.services;

import com.dmfa.picoplaca.beans.ParametersBean;
import com.dmfa.picoplaca.exceptions.GeneralException;

public interface EvaluatorService {
	
	public boolean validate(ParametersBean params) throws GeneralException;

}
