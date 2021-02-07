// This javascript file makes a request to Youtube's API about the number of Subscribers of the channel PewDiePie ( id : UC-lHJZR3Gqxm24_Vd_AJ5Yw )
// and the channel T-Series ( id : UCq-Fj5jknLsUf-MWSy4_brA ) - we use our personnal Youtube's API keys
// Key 1 : AIzaSyCyzhRIBvmdD7wxkb49wK0FZbXSbT83aX4
// Key 2 : AIzaSyDv-hxPpcOJFQ2dtfDZ_6dl_INVn1Rtfac

function api(){
    let pewdiepie = new XMLHttpRequest();
    let tSeries = new XMLHttpRequest();
    let pewdiepie_subs;
    let tSeries_subs;

    function numberWithSpaces(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, " ");              // Because it's easier to read big numbers when they are 'spaced'.
    }
    pewdiepie.open('GET', "https://www.googleapis.com/youtube/v3/channels?part=statistics&id=UC-lHJZR3Gqxm24_Vd_AJ5Yw&key=AIzaSyCyzhRIBvmdD7wxkb49wK0FZbXSbT83aX4");    // We get PewDiePie's stats
    tSeries.open('GET', "https://www.googleapis.com/youtube/v3/channels?part=statistics&id=UCq-Fj5jknLsUf-MWSy4_brA&key=AIzaSyDv-hxPpcOJFQ2dtfDZ_6dl_INVn1Rtfac");      // We get T-Series's stats
    pewdiepie.onload = function() {
        let data = numberWithSpaces(JSON.parse(this.response).items[0].statistics.subscriberCount);     // We grab PewDiePie's subs
        pewdiepie_subs = JSON.parse(this.response).items[0].statistics.subscriberCount;
        document.getElementById("pewds__subs").textContent = data;
    };
    tSeries.onload = function() {
        let data = numberWithSpaces(JSON.parse(this.response).items[0].statistics.subscriberCount);     // We grab T-Series's subs
        tSeries_subs = JSON.parse(this.response).items[0].statistics.subscriberCount;
        if (pewdiepie_subs > tSeries_subs) {                                                                                                                                                 // If PewDieKind is ahead
            document.getElementById("pewds_lead").innerHTML = `Pewdiepie leads by <span id="pewds_lead_sub">${numberWithSpaces(pewdiepie_subs - tSeries_subs)}</span>`;         // Display the difference of subs
        }
        else if (pewdiepie_subs < tSeries_subs) {                                                                                                                                            // If T-Bad is ahead
            document.getElementById("t-series_lead").innerHTML = `T-Series leads by <span id="t-series_lead_sub">${numberWithSpaces(tSeries_subs - pewdiepie_subs)}</span>`;    // Display the difference of subs
        }
        document.getElementById("t-series__subs").textContent = data;
    };
            // If PewDiePie is in the leads, we display the difference - same if T-Series leads.
            // If they have the same amount, nothing happen - we don't really want to see that do we ?

    pewdiepie.send();
    tSeries.send();
}


setInterval(() => {api()}, 3000);      // We make this function repeat every 3 seconds - we can't really reduce this otherwise we'll exceed our daily quota of API requests.
