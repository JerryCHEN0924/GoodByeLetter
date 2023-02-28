package com.iSpanProject.GoodByeletter.model.YiJie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface YJCustomerRepository extends JpaRepository<YJCustomer, Integer> {
	//value ="from Customer where acc = ?1"中的Customer 要與前面繼承的名稱相同否則會豹錯unexpected token
	@Query(value="from YJCustomer where acc = ?1")
	public YJCustomer findCustomerByAcc(String acc);

	@Query(value="from YJCustomer where acc = :a and level = :lev")
	public YJCustomer findCustomerByAccAndLevel(@Param("a") String acc,@Param("lev") Integer level);
	
	//findByLevelOrderById => 可以用來查詢所有level2的廣告商
	@Query(value="from YJCustomer where level = :lev order by id asc")
	public List<YJCustomer> findCustomerByLevelOrderById( @Param("lev") Integer level);
	
	/////////////////////  (原生語法)  ////////////////////////
	//原生語法(大小無關係) => 在交易量很大的時候使用
	//sql語法中table與Column的名稱先去Customer.java檔案內確認
	@Query(value="select * from member where account = :a", nativeQuery = true)
	public YJCustomer findCustomerByAccNativeQuery(@Param("a") String acc);
	
	@Transactional //一但刪除失敗，將整筆動作回滾至未執行確保資料一致
	@Modifying //@Query查詢時，需要修改或刪除資料須加上此標註
	@Query(value = "delete from member where memberId = ?1", nativeQuery = true)
	public void deleteCustomerById(Integer id);
	
	//JpaRepostitory透過方法名稱直接查詢 新東西
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
	public List<YJCustomer> findByAccContaining(String str);
}
