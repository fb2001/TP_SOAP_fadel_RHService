package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Client;

import java.util.ArrayList;

public interface ClientRepository {
    ArrayList<Client> getClients();
    Client getClient(int id);
    boolean addClient(Client client);
    void deleteClient(int id);
}
