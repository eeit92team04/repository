package model;

import java.util.List;

public interface OrderDetailsDAO {
	List<OrderDetailsBean> select(int odd_mealid);
	OrderDetailsBean update(int odd_id, int odd_mealid, int ordd_count, double odd_money, int odd_orderid);
}
