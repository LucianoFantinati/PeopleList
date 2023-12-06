package com.mercadolibre.people_list_group_6.service;

import com.mercadolibre.people_list_group_6.model.Person;
import com.mercadolibre.people_list_group_6.model.Stack;
import com.mercadolibre.people_list_group_6.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StackService {
    private final StackRepository stackRepository;

    public Stack create(Stack stack){
        return stackRepository.save(stack);
    }

    public void delete(UUID id) {
        stackRepository.deleteById(id);
    }

    public void update(UUID id, Stack updatedStack) {
        Stack existingStack = stackRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Stack not found with id: " + id));

        existingStack.setName(updatedStack.getName());

        stackRepository.save(existingStack);
    }
}
