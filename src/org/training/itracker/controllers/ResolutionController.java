package org.training.itracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.itracker.beans.Resolution;
import org.training.itracker.constants.Constants;
import org.training.itracker.service.ResolutionService;
import org.training.itracker.utilities.BackButton;

@Controller
public class ResolutionController {

	@Autowired
	private ResolutionService resolutionService;

	@RequestMapping(value = "/resolutions")
	public String resolutions(HttpSession session) {

		List<Resolution> resolutions;
		resolutions = resolutionService.getResolutions();
		session.setAttribute(Constants.ATTRIBUTE_RESOLUTIONS, resolutions);

		BackButton.showBackHideSubmit(session);
		return "resolutions";
	}

	@RequestMapping(value = "/resolution")
	public String resolution(HttpSession session,
			@RequestParam(value = "id") int id) {

		Resolution resolution = resolutionService.getResolution(id);
		session.setAttribute(Constants.ATTRIBUTE_RESOLUTION, resolution);

		BackButton.showBackHideSubmit(session);
		return "resolutionEdit";
	}

	@RequestMapping(value = "/updateResolution")
	public String updateResolution(HttpSession session,
			@RequestParam(value = "name") String name) {

		Resolution resolution = (Resolution) session
				.getAttribute(Constants.ATTRIBUTE_RESOLUTION);

		resolution.setResolutionName(name);
		resolutionService.updateResolution(resolution);

		return "forward:/resolutions";
	}

	@RequestMapping(value = "/resolutionSubmit")
	public String resolutionSubmit(HttpSession session) {
		BackButton.showBackHideSubmit(session);
		return "resolutionSubmit";
	}

	@RequestMapping(value = "/saveResolution")
	public String saveResolution(HttpSession session,
			@RequestParam(value = "name") String name) {

		Resolution resolution = new Resolution();
		resolution.setResolutionName(name);
		resolutionService.saveResolution(resolution);

		return "forward:/resolutions";
	}
}