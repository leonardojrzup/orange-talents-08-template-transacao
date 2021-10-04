package br.com.leonardo.transacao.kafka;

import br.com.leonardo.transacao.transacao.Transacao;
import br.com.leonardo.transacao.transacao.TransacaoForm;
import br.com.leonardo.transacao.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

    @Autowired(required=true)
    TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void coleta(TransacaoForm transacaoForm) {

        try {
            Transacao transacao = transacaoForm.toModel();
            transacaoRepository.save(transacao);
            System.out.println("Transação recebida com sucesso para o id {} " + transacaoForm.getId());

        } catch (Exception exception){
            System.out.println("Transação recebida com falha para a transação " + transacaoForm.getId());
            System.out.println(exception.getCause());
            System.out.println(exception.getMessage());
        }
    }
}
