import { Component, OnInit ,ViewChild} from '@angular/core';
import { AgGridNg2 } from 'ag-grid-angular';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridNg2;
  columnDefs = [
    { headerName: 'Name', field: 'name' },
    { headerName: 'Age', field: 'age' },
    { headerName: 'Job Title', field: 'job' },
    { headerName: 'Height(in cm)', field: 'height' },
    { headerName: 'Compatibility Score', field: 'score' },
    { headerName: 'Contacts', field: 'contact' },
    { headerName: 'favourite', field: 'favourite' },
    { headerName: 'Religion', field: 'religion' },
    { headerName: "City Name", field: "city"},
    {
      headerName: 'Profile Pic', suppressFilter: true,
      template:
      `<button type="button"  mat-raised-button data-action-type="profilepic" class="btn btn-default">Profile Pic</button>`
    },

  ];

 rowData: any;
 
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<any>("/sparkMatches/api/matches", {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response)
        this.rowData = response.body;
      })

  }
  public onRowClicked(e) {
    if (e.event.target !== undefined) {
      let data = e.data;
      let actionType = e.event.target.getAttribute("data-action-type");

      switch (actionType) {

        case "profilepic":
          return this.onActionProfilePic(data);
      }
    }
  }
  public onActionProfilePic(data: any) {

    console.log(data.main_photo)
    window.location.href=data.photo;

  }
  public getAgeRange(value:string){
    console.log("hello")
    console.log(value)
    this.http.get<any>("/sparkMatches/api/matches/spec?search="+value, {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
          this.rowData = response.body;
      })
      .catch(console.log);
  }
  public getHeightRange(value:string){
    console.log("Height function called")
    this.http.get<any>("/sparkMatches/api/matches/spec?search="+value, {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
       this.rowData = response.body;
      })
      .catch(console.log);
  }
  public getDistanceRange(){
    this.http.get<any>("", {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
     //   this.rowData = response.body;
      })
      .catch(console.log);
  }
  public getCompatibilityScoreRange(value:string){
    this.http.get<any>("/sparkMatches/api/matches/spec?search="+value, {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
       this.rowData = response.body;
      })
      .catch(console.log);
  }
  public isFavourite(value:String){
    this.http.get<any>("/sparkMatches/api/matches/spec?search="+value, {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
       this.rowData = response.body;
      })
      .catch(console.log);
  }
  public isIncontact(value:String){
    this.http.get<any>("/sparkMatches/api/matches/spec?search="+value, {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
       this.rowData = response.body;
      })
      .catch(console.log);
  }
  public hasphoto(value:String){
    this.http.get<any>("/sparkMatches/api/matches/hasPhoto/"+value, {
      observe: 'response'
    })
      .toPromise()
      .then(response => {
        console.log(response);
           this.rowData = response.body;
      })
      .catch(console.log);
  }
}
