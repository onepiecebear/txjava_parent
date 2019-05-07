package cn.tx.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreFilter  extends ZuulFilter{
    @Override
    //过滤器类型
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    //过滤器同类型的优先级，过滤器顺序数越小优先级越高
    public int filterOrder() {
        return 0;
    }

    @Override
    //过滤器开启开关 返回true为开启
    public boolean shouldFilter() {
        return true;
    }

    @Override
//    框架未对返回值做处理

    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        if(token==null || token.equals("")){
            //过滤器拦截不往下走了，直接返回数据
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("未登录");
        }
        ctx.set("qwer");
        return null;
    }
}
