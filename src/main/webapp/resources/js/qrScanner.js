// Very simple JS, mostly the example of Instantscan.
// Scans the qr code and submits it using the form generated by JSF.

let scanner = new Instascan.Scanner({ video: document.getElementById('preview') });
scanner.addListener('scan', function (content) {
    console.log('Scanned QR-Code: ' + content);
    
    let shipmentIdInput = document.getElementById('input_shipmentForm:shipmentId');
    shipmentIdInput.value = content;
    let shipmentForm = document.getElementById('shipmentForm:submit');
    // This seems kind of wrong, as one would usually submit the whole form.
    // But JSF depends on diffirent commandButtons, so the correct button has
    // to be submitter.
    // Will leave it like this as it is only a 'toy feature' and not crucial
    // for the actual application.
    shipmentForm.click();
});
Instascan.Camera.getCameras().then(function (cameras) {
    if (cameras.length > 0) {
        scanner.start(cameras[0]);
    } else {
        console.error('No cameras found.');
    }
}).catch(function (e) {
    console.error(e);
});
