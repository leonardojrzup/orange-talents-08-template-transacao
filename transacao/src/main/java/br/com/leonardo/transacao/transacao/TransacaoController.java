package br.com.leonardo.transacao.transacao;


import br.com.leonardo.transacao.cartao.Cartao;
import br.com.leonardo.transacao.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @GetMapping("/transacoes/{id}")
    public ResponseEntity<?> detalhar(@PathVariable String id) {

        Cartao cartao = cartaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cartão não encontrado no banco de dados"));

        List<Transacao> transacoes = transacaoRepository.findFirst10ByCartaoId(id);
        List<TransacaoDTO> dtos = transacoes.stream().map(TransacaoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
}
