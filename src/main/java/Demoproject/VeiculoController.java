package Demoproject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeiculoController {

	@Autowired
	VeiculoRepository repository;

	@GetMapping("/veiculo")
	public List<Veiculo> getAllVeiculos() {
		return repository.findAll();
	}

	@PostMapping("/veiculo")
	public Veiculo saveVeiculo(@RequestBody Veiculo veiculo) {
		return repository.save(veiculo);
	}
}