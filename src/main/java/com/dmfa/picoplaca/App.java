package com.dmfa.picoplaca;

import com.dmfa.picoplaca.beans.ParametersBean;
import com.dmfa.picoplaca.services.EvaluatorService;
import com.dmfa.picoplaca.services.impl.EvaluatorServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		System.out.println("Please enter License Plate Number, date and time, for example ");
		System.out.println("XXX-0000 dd/MM/yyyy HH:mm ");

		if (args != null && args.length == 3) {

			EvaluatorService eva = new EvaluatorServiceImpl();

			ParametersBean params = new ParametersBean();
			params.setLicensePlateNumber(args[0]);
			params.setDate(args[1]);
			params.setTime(args[2]);
			if(eva.validate(params)) {
				System.out.println("You have Pico y Placa");
			} else {
				System.out.println("You don't have Pico y Placa");
			}
		}
    }
}
