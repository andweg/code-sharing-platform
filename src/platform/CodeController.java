package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CodeController {

    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{uuid}")
    public String getCodeHtml(Model model, @PathVariable String uuid) {
        Code code = codeService.updateViewsByUuid(uuid);
        model.addAttribute("code", code.getCode());
        model.addAttribute("date", code.getDate());
        model.addAttribute("isTimeRestricted", code.isTimeRestricted());
        model.addAttribute("time", code.getTime());
        model.addAttribute("isViewsRestricted", code.isViewsRestricted());
        model.addAttribute("views", code.getViews());
        return "code";
    }

    @GetMapping("/api/code/{uuid}")
    @ResponseBody
    public Map<String, Object> getCodeJson(@PathVariable String uuid) {
        Code code = codeService.updateViewsByUuid(uuid);
        return Map.of("code", code.getCode(),
                "date", code.getDate(),
                "time", code.isTimeRestricted() ? code.getTime() : 0,
                "views", code.isViewsRestricted() ? code.getViews() : 0
        );
    }

    @GetMapping("/code/new")
    public String getNewCodeHtml() {
        return "new";
    }

    @GetMapping("/api/code/latest")
    @ResponseBody
    public List<Code> getLatestJson() {
        return codeService.getLatest();
    }

    @GetMapping("/code/latest")
    public String getLatestHtml(Model model) {
        List<Code> latest = getLatestJson();
        model.addAttribute("snippets", latest);
        return "latest";
    }

    @PostMapping("/api/code/new")
    @ResponseBody
    public Map<String, String> postCode(@RequestBody Code code) {
        return Map.of("id", codeService.add(code).toString());
    }

}