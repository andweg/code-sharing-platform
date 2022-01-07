package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CodeService {

    private final CodeRepository codeRepo;

    @Autowired
    public CodeService(CodeRepository codeRepo) {
        this.codeRepo = codeRepo;
    }

    public String add(Code code) {
        code.setDate(LocalDateTime.now());
        code.setUuid(UUID.randomUUID().toString());
        code.setRestrictions();
        code.setExpirationDate();
        return codeRepo.save(code).getUuid();
    }

    public Code findById(long id) {
        return codeRepo.findById(id).orElseThrow(CodeNotFoundException::new);
    }

    public Code findByUuid(String uuid) {
        return codeRepo.findByUuid(uuid).orElseThrow(CodeNotFoundException::new);
    }

    public Code updateViewsByUuid(String uuid) {
        Code code = codeRepo.findByUuid(uuid).orElseThrow(CodeNotFoundException::new);
        if (!code.isAccessible()) {
            throw new CodeNotFoundException();
        }
        code.setViews(code.getViews() - 1);
        codeRepo.save(code);
        return code;
    }

    private long count() {
        return codeRepo.count();
    }

    public List<Code> getLatest() {
        List<Code> latest = new ArrayList<>();
        for (long i = count(); latest.size() < 10 && i > 0; i--) {
            Code code = findById(i);
            if (!code.isTimeRestricted() && !code.isViewsRestricted()) {
                latest.add(code);
            }
        }
        return latest;
    }

}
