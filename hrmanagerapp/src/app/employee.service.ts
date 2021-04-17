import { Injectable } from "@angular/core";
import { Employee } from './employee';
import {  Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})

export class EmployeeService {
    private apiUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getEmployees(): Observable<any> {
        return this.http.get<any>(`${this.apiUrl}/employees/all`);
    }

    public addEmployee(employee: Employee): Observable<Employee> {
        return this.http.post<Employee>(`${this.apiUrl}/employees/add`, employee);
    }

    public updateEmployee(employee: Employee): Observable<Employee> { 
        return this.http.put<Employee>(`${this.apiUrl}/employees/update`, employee);
    }

    public deleteEmployee(employeeId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/employees/delete/${employeeId}`);
    }
}