/**
 * 
 */
package net.mingsoft.attention.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.util.PageUtil;

import net.mingsoft.attention.entity.BasicAttentionEntity;

/**
 * 
 * 关注插件
 * @author 铭飞开发团队
 * @version 
 * 版本号：100-000-000<br/>
 * 创建日期：2017年4月7日<br/>
 * 历史修订：<br/>
 */
public interface IBasicAttentionDao extends IBaseDao {
	
	/**
	 * 根据basicId,关注类型,用户ID,AppId查询</br>
	 * 查询用户是否关注过该商品</br>
	 * @param basicAttention 保存basicId,关注类型,用户ID,AppId查询的关注实体
	 * @return
	 */
	public BasicAttentionEntity getEntityByPeopleAttention(@Param("basicAttention") BasicAttentionEntity basicAttention);
	
	/**
	 * 根据用户ID和APPID查询用户关注内容列表(带分页)
	 * @param peopleId 用户ID
	 * @param appId 应用ID
	 * @param page 分页
	 * @param attentionType 积分类型
	 * @param modelId 模块编号
	 * @return 用户关注列表
	 */
	@Deprecated
	public List<BasicAttentionEntity> queryPageByPeopleIdAndAppId(@Param("peopleId")int peopleId,@Param("appId")int appId,@Param("attentionType") int attentionType,@Param("modelId") Integer modelId,@Param("page")PageUtil page);
	
	/**
	 * 根据用户ID和APPID查询用户关注内容数量
	 * @param peopleId 用户ID
	 * @param appId 应用ID
	 * @param attentionType 积分类型
	 * @return 数量
	 */
	@Deprecated
	public int queryCountByPeopleIdAndAppId(@Param("peopleId")int peopleId,@Param("appId")int appId,@Param("attentionType") int attentionType,@Param("modelId") Integer modelId);
	

	/**
	 * 根据收藏id数组和用户id删除收藏记录
	 * @param ids 收藏id数组
	 * @param peopleId 用户id
	 * @param basicAttentionType 类型
	 */
	public void delete(@Param("ids") int[] ids,@Param("peopleId") int peopleId,@Param("basicAttentionType")int basicAttentionType);
	
	/**
	 * 统计当前所属类别的总数
	 * @param basicAttentionEntity
	 * @return 总数
	 */
	public int count(BasicAttentionEntity basicAttentionEntity);
}
