package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import markowitz.Stock;

@ManagedBean
public class StockController {
	//private Stock s = new Stock("bimboa");
	private List<Stock>stocks = new ArrayList<Stock>();
	private Stock selectedStock;
	private Stock[] selectedStocks;
	
	public StockController(){
		
	}
	
	public Stock getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(Stock selectedStock) {
		this.selectedStock = selectedStock;
	}

	public Stock[] getSelectedStocks() {
		return selectedStocks;
	}

	public void setSelectedStocks(Stock[] selectedStocks) {
		this.selectedStocks = selectedStocks;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
}
