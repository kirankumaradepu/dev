Ext.define('app.controller.ReservationController',{
    extend: 'Ext.app.Controller',
    name: 'reservationcontroller',
    views: ['app.view.ReservationsGrid','app.view.SeatSelectionForm' ],
    stores:['app.store.ReservationStore'],
    models:['app.model.ReservationModel'],
    refs:[{ref:'reservationGrid',selector:'ReservationsGrid'},
        {ref:'selectionForm',selector:'SeatSelectionForm'}],
    init:function(){
      this.control({
          'ReservationsGrid':{
              gridClick: this.doCreatePopUpForm
          }
      })
    },
    doCreatePopUpForm: function(view, td, index, record, tr, rowIndex, e, eOpts){
        console.log('ReservationController, method: doCreatePopUpForm');
        var record = Ext.create('app.model.ReservationModel',{
            confirmationNo : record.data.confirmationNo,
            customerName : record.data.customerName,
            seatNo : record.data.seatNo,
            ticketType : record.data.ticketType
        });
        Ext.create('Ext.window.Window', {
            title: 'Seat Selection',
            height: 200,
            width: 400,
            layout: 'fit',
            items: {
                xtype: 'SeatSelectionForm',
                header: false,
                record:record.data
            }
        }).show();
    },
    constructor: function () {
        this.callParent(arguments);
    }
});