Ext.define('app.store.ReservationStore', {
    extend: 'Ext.data.Store',
    model: 'app.model.ReservationModel',
    autoLoad: true,
    proxy:{
        actionMethods:{create:'POST', read: 'GET', update: 'POST', destroy: 'POST'},
        url:'/reservations/getReservations',
        type: 'ajax',
        reader: {
            type: 'json',
            totalProperty: 'size'
        }
    }
});