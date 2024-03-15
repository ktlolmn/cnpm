package cnpm.controller.Component;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DsMuonPhongHoc {
	@RequestMapping("/home")
    public String home(ModelMap modelMap) {
    	return"Components/BoardContent/DsMuonPhongHoc";
    }
}
