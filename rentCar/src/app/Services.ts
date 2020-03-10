import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class Services {

    private serverUrl: string ='http://localhost:50658';

    constructor(private http: HttpClient) {
        this.http = http;
    }

    saveCustomerOwner(customer){
        return this.http.post( this.serverUrl +'/service/save',customer);
    }

}