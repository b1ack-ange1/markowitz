package beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import markowitz.Stock;

@ManagedBean
public class StockController {
	private final Stock ACMX;
	private final Stock BIMBOA;
	private final Stock ELEKTRA;
	private final Stock SAREB;
	
	private List<List<Double>>lista = new ArrayList<List<Double>>(); 
	public Stock getELEKTRA() {
		return ELEKTRA;
	}

	public Stock getSAREB() {
		return SAREB;
	}

	public Stock getACMX() {
		return ACMX;
	}

	public Stock getBIMBOA() {
		return BIMBOA;
	}

	public StockController(){
		String path = "STOCKS";
		ACMX = new Stock(path + File.separatorChar+"AC.MX.csv");
		lista.add(ACMX.getXix());
		BIMBOA = new Stock(path + File.separatorChar+"BIMBOA.MX.csv");
		lista.add(BIMBOA.getXix());
		ELEKTRA = new Stock(path + File.separatorChar+"ELEKTRA.MX.csv");
		lista.add(ELEKTRA.getXix());
		SAREB = new Stock(path + File.separatorChar+"SAREB.MX.csv");
		lista.add(SAREB.getXix());
		
		for(int i=0;i<lista.size();i++){
			for(int j=0;j<lista.size();j++)
			{
				
			}
		}
	}
	
}
