package com.example.lms_Clone.controllers;


import com.example.lms_Clone.model.Address;
import com.example.lms_Clone.model.Party;
import com.example.lms_Clone.model.SearchParty;
import com.example.lms_Clone.services.AddressService;
import com.example.lms_Clone.services.PartyService;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/parties")
@CrossOrigin(origins = "http://localhost:4200")
public class CreateParty {

    private final PartyService partyService;

    private  final AddressService addressService;
    public CreateParty(PartyService partyService, AddressService addressService) {
        this.partyService = partyService;
        this.addressService = addressService;
    }

    @PostMapping("/addParty")
    public ResponseEntity<Party> addParty(@RequestBody Party party){
        Party parties=this.partyService.addParty(party);
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }
    @PostMapping("/addAddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address addres=this.addressService.addAddress(address);
        return new ResponseEntity<>(addres, HttpStatus.OK);
    }

    @GetMapping("/getParties")
    public  ResponseEntity<List<Party>> getAllParties(){
       // Pageable paging = PageRequest.of(page, size);
        List<Party> parties=this.partyService.getParties();
        return  new ResponseEntity<>(parties,HttpStatus.OK);
    }

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id){
        Address addres=addressService.findAddressById(id);
        return new ResponseEntity<>(addres,HttpStatus.OK);
    }
    @GetMapping("/getParty/{id}")
    public  ResponseEntity<Party> getPartyById(@PathVariable("id") Long id){
        Party parties=this.partyService.findPartyById(id);
        return new ResponseEntity<>(parties,HttpStatus.OK);
    }

    @PostMapping("/postSearch")
    public ResponseEntity<Page<Party>>  search(@RequestBody SearchParty party){
        System.out.println(party);
        return new ResponseEntity<>(this.partyService.searchByQuery(party),HttpStatus.OK);
        //return this.getSearchParties(party);
    }

    @GetMapping("/searchParties")
    public ResponseEntity<Page<Party>> getSearchParties(SearchParty searchParty){
        return new ResponseEntity<>(this.partyService.searchByQuery(searchParty),HttpStatus.OK);
    }

//    @GetMapping("/searchParties")
//    public ResponseEntity<Page<Party>> getSearchParties(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam() String partyName,
//                                                        @RequestParam() Long partyId, @RequestParam() String partyType, @RequestParam() String roles,
//                                                        @RequestParam() String status, @RequestParam()Date createdDate,@RequestParam() Date lastModifiedDate){
//        SearchParty searchParty=new SearchParty();
//        searchParty.setPartyId(partyId);
//        searchParty.setPartyName(partyName);
//        searchParty.setCreatedDate(createdDate);
//        searchParty.setLastModifiedDate(lastModifiedDate);
//        searchParty.setPage(page);
//        searchParty.setRoles(roles);
//        searchParty.setPartyType(partyType);
//        searchParty.setSize(size);
//        searchParty.setStatus(status);
//
//        return new ResponseEntity<>(partyService.searchByQuery(searchParty),HttpStatus.OK);
//    }




    @PutMapping("/updateParty/{id}")
    public ResponseEntity<Party> updateParty(@PathVariable("id") Long id, @RequestBody Party party){
        party.setPartyId(id);
        Party parties=this.partyService.updateParty(party);
        return new ResponseEntity<>(parties,HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id, @RequestBody Address address){
        address.setId(id);
        Address adress=this.addressService.updateAddress(address);
        return new ResponseEntity<>(adress,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public  ResponseEntity<?> deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteParty/{id}")
    public  ResponseEntity<?> deleteParty(@PathVariable("id") Long id){
        partyService.deleteParty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
