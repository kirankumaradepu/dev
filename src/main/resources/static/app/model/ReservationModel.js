Ext.define('app.model.ReservationModel',{
    extend: 'Ext.data.Model',
    alias: 'widget.ReservationModel',
    fields: [
        { name: 'id', type: 'int' },
        { name: 'customerName', type: 'string' },
        { name: 'seatNo', type: 'string' },
        { name: 'ticketType', type: 'string' },
        { name: 'confirmationNo', type: 'string' }
    ]
});