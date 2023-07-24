package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.CategoryOfManualRequest;
import br.com.sicoob.helpdesk.dto.response.CategoryOfManualResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.repository.CategoryOfManualsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryOfManualsService {

    @Autowired
    private CategoryOfManualsRepository repository;

    /*
    metodo para salvar uma nova categoria
     */
    public List<CategoryOfManuals> listAllCategory() {

    return repository.findAll();

    }

    /*
    /metodo para salvar uma nova categoria
     */
    public CategoryOfManuals createNewCategory(CategoryOfManuals category) {
        return repository.save(category);
    }


}
