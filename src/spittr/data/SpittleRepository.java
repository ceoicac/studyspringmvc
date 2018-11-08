package spittr.data;

import java.util.List;

import spittr.Spittle;

/**
 * 数据访问的Repository
 * @author Administrator
 *
 */
public interface SpittleRepository {
	List<Spittle> findSpittle(long max,int count);
}
