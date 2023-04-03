package at.ac.tuwien.inso.sepm.ticketline.client.rest;

import at.ac.tuwien.inso.sepm.ticketline.client.exception.DataAccessException;
import at.ac.tuwien.inso.sepm.ticketline.rest.event.EventDTO;
import at.ac.tuwien.inso.sepm.ticketline.rest.event.Top10EventDTOImpl;
import at.ac.tuwien.inso.sepm.ticketline.rest.util.PaginationWrapper;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface EventRestClient {

    /**
     * Finds an event entry by the given id
     * @param id id of the event
     * @return EventDTO object
     * @throws DataAccessException in case something went wrong
     */
    EventDTO findOneById(Long id) throws DataAccessException;

    /**
     * Finds all event entries
     * @param request Pageable request
     * @return A PaginationWrapper object containing list of results and pagination relevant information
     * @throws DataAccessException in case something went wrong
     */
    PaginationWrapper<EventDTO> findAll(Pageable request) throws DataAccessException;

    /**
     * Finds event entries in which the artist with the given id performs
     * @param id id of the artist
     * @return A list of event entries
     * @throws DataAccessException in case something went wrong
     */
    PaginationWrapper<EventDTO> findByArtistId(Long id, Pageable request) throws DataAccessException;

    /**
     * Finds event entries conforming to the parameters provided in params
     * @param params Map containing parameters inputted by the user
     * @return A list of event entries
     * @throws DataAccessException in case something went wrong
     */
    PaginationWrapper<EventDTO> findByCustomCriteria(MultiValueMap<String, String> params, Pageable request) throws DataAccessException;

    /**
     * Find top 10 events by given search criteria
     * @param params search criteria by which the top 10 events will be found
     * @return  A list of top 10 events
     * @throws DataAccessException in case something went wrong
     */
    List<Top10EventDTOImpl> findTop10Event(MultiValueMap params) throws DataAccessException;
}
