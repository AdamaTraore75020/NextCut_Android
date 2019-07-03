package traore.adama.nextcut_android.ui.fragment

import androidx.lifecycle.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.utils.extensions.shortToast
import traore.adama.nextcut_android.interfaces.IListItemClick
import traore.adama.nextcut_android.ui.adapter.NextcuterAdapter
import traore.adama.nextcut_android.viewmodel.HomeViewModel

class HomeFragment : Fragment(), IListItemClick<Nextcuter> {

    companion object {
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    private lateinit var adapter : NextcuterAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = NextcuterAdapter(activity?.application!!)
        rcvMain.setHasFixedSize(true)
        rcvMain.layoutManager = GridLayoutManager(context, 1)
        rcvMain.adapter = adapter

        setToolbarTitle(getString(R.string.app_name))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        observeViewModel(viewModel)
    }


    //region functions
    fun setToolbarTitle(title: String){
        toolbar.title = title
    }


    fun observeViewModel(viewModel: HomeViewModel){
        //update list when data changes
        //To avoid Leaking LiveData observers in Fragments, the recommended solution is to use fragment’s view lifecycle via getViewLifecycleOwner()
        viewModel.getNextcuters().observe(viewLifecycleOwner, Observer<List<Nextcuter>> { list ->
            list?.let {
                adapter.swapData(list)
            }
        } )
    }

    override fun itemClicked(item: Nextcuter, view: View) {
        shortToast(view.id.toString())
    }

}