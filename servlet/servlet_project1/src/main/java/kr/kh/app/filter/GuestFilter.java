package kr.kh.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.MemberVO;

@WebFilter({"/login", "/signup"})
public class GuestFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		MemberVO user = (MemberVO)httpServletRequest.getSession().getAttribute("user");
		if(user != null) {
			request.setAttribute("msg", "이미 로그인 되어 있습니다");
			request.setAttribute("url", "");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
}
