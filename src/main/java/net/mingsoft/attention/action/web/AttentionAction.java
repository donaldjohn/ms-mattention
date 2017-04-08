package net.mingsoft.attention.action.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingsoft.people.action.BaseAction;

import net.mingsoft.attention.biz.IBasicAttentionBiz;

@Controller("attention")
@RequestMapping("/attention")
public class AttentionAction extends BaseAction {
	
	/**
	 * 注入关注业务层
	 */
	@Autowired
	private IBasicAttentionBiz basicAttentionBiz;
	
	/**
	 * 统计当前所属类别的总数
	 * @param basicAttentionEntity
	 * <i>basicAttention参数包含字段信息参考：</i><br/>
	 * basicAttentionBasicId - 信息编号：
	 * basicAttentionType 关注类型 具体平台也可以根据自身的规则定义
	 * <dt><span class="strong">返回</span></dt><br/>
	 * 直接返回总数，注意：非json格式
	 */
	@RequestMapping(value="/count")
	@ResponseBody
	public void count(@ModelAttribute net.mingsoft.attention.entity.BasicAttentionEntity basicAttentionEntity,
	    javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		if(basicAttentionEntity != null){
			int total = basicAttentionBiz.count(basicAttentionEntity);
			this.outJson(response, total);
		}else{
			this.outJson(response, 0);
		}
	}
	
}
