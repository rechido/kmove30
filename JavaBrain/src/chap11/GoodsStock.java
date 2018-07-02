package chap11;

public class GoodsStock {
	String goodsCode;
	int stockNum;
	
	public GoodsStock(String goodsCode, int stockNum) {
		super();
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}

	@Override
	public String toString() {
		
		String str = "상품코드: " + goodsCode + " " +
					"재고수량: " + stockNum;
		return str;
	}
	
	
}
