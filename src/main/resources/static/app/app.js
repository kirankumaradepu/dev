Ext.application({
    requires: ['Ext.container.Viewport', 'app.view.ReservationsGrid'],
    name: 'app',
    views:['app.view.SeatSelectionForm','app.view.ReservationsGrid'],
    controllers:['app.controller.ReservationController'],
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'auto',
            region: 'center',
            items: [{
                xtype: 'ReservationsGrid',
                width: 700,
                height: 500
            }]
        });
    }
});