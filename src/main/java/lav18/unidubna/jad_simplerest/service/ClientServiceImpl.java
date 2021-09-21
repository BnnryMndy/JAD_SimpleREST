package lav18.unidubna.jad_simplerest.service;

import lav18.unidubna.jad_simplerest.dao.ClientDao;
import lav18.unidubna.jad_simplerest.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {
    ClientDao clientDao = new ClientDao();

    @Override
    public void create(Client client) {
        clientDao.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientDao.findAll();
    }

    @Override
    public Client read(int id) {
        return  clientDao.findById(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (clientDao.findById(id) == null) {
            clientDao.delete(client);
            client.setId(id);
            clientDao.save(client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        clientDao.delete(clientDao.findById(id));

        return true;
    }
}
