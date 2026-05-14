package com.petitions.controller;

import com.petitions.model.Petition;
import com.petitions.service.PetitionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/petitions")
@RequiredArgsConstructor
public class PetitionController {

    private final PetitionService petitionService;

    @GetMapping
    public String listPetitions(Model model) {
        model.addAttribute("petitions", petitionService.findAll());
        return "petitions/list";
    }

    @GetMapping("/new")
    public String newPetitionForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "petitions/form";
    }

    @PostMapping
    public String createPetition(@ModelAttribute Petition petition,
            RedirectAttributes redirectAttributes) {
        petitionService.create(petition);
        redirectAttributes.addFlashAttribute("success", "Петицію успішно створено!");
        return "redirect:/petitions";
    }

    @GetMapping("/{id}")
    public String viewPetition(@PathVariable Long id, Model model,
            HttpServletRequest request) {
        Petition petition = petitionService.findById(id);
        String baseUrl = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort();
        String voteUrl = petitionService.generateVoteUrl(id, baseUrl);
        model.addAttribute("petition", petition);
        model.addAttribute("voteUrl", voteUrl);
        return "petitions/view";
    }

    @PostMapping("/{id}/delete")
    public String deletePetition(@PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        petitionService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Петицію видалено.");
        return "redirect:/petitions";
    }

    @GetMapping("/{id}/vote")
    public String voteForm(@PathVariable Long id, Model model) {
        model.addAttribute("petition", petitionService.findById(id));
        return "petitions/vote";
    }

    @PostMapping("/{id}/vote")
    public String castVote(@PathVariable Long id,
            @RequestParam String voterName,
            RedirectAttributes redirectAttributes) {
        try {
            petitionService.vote(id, voterName);
            redirectAttributes.addFlashAttribute("success",
                    "Ваш голос зараховано! Дякуємо за участь.");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/petitions/" + id;
    }
}