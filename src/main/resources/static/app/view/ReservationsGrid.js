Ext.define('app.view.ReservationsGrid', {
    extend: 'Ext.grid.Panel',
    title: 'Reservations',
    alias: 'widget.ReservationsGrid',
    columns: [
        {text: 'CustomerName', dataIndex: 'customerName', flex: 1},
        {text: 'Seat No.', dataIndex: 'seatNo', flex: 1},
        {text: 'Ticket Type', dataIndex: 'ticketType', flex: 1},
        {text: 'Confirmation No.', dataIndex: 'confirmationNo', flex: 1}
    ],
    height: 200,
    width: 400,
    initComponent: function () {
        this.store = new Ext.create('app.store.ReservationStore', {
            storeId: 'reservationStore'
        });
        this.callParent(arguments);
    },
    listeners: {
        cellclick: function (view, td, index, record, tr, rowIndex, e, eOpts) {
            this.fireEvent('gridClick', view, td, index, record, tr, rowIndex, e, eOpts);
        }
    }
});