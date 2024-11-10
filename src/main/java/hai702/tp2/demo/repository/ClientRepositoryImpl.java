package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Client;

import java.util.ArrayList;

public class ClientRepositoryImpl implements ClientRepository {

    ArrayList<Client> clients = new ArrayList<>();

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public Client getClient(int id) {
       for (Client c : clients) {
           if(c.getIdentifiant_client().equals(id)){
               return c;
           }
       }
        System.err.println("Client "+id+" not found");
        return null;
    }

    @Override
    public boolean addClient(Client client) {
        return clients.add(client);
    }

    @Override
    public void deleteClient(int id) {
        for (Client c : clients) {
            if(c.getIdentifiant_client().equals(id)){
                clients.remove(c);
            }
        }
        System.err.println("Client "+id+" not found");

    }
}
